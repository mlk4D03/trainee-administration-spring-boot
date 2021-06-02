package com.trivadis.administration.trainee.controller;

import com.trivadis.administration.trainee.dto.ModuleDTO;
import com.trivadis.administration.trainee.entities.Lecture;
import com.trivadis.administration.trainee.entities.Module;
import com.trivadis.administration.trainee.service.ModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/module")
public class ModuleController {

    private ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping
    public ModuleDTO saveModule(@RequestBody ModuleDTO moduleDTO) {
        Module module = this.moduleService.saveModule(moduleDTO);
        return toModuleDTO(module);
    }

    @GetMapping
    public Iterable<ModuleDTO> getAllModules() {
        List<Module> modules = (List<Module>) this.moduleService.getAllModules();
        return modules.stream().map(this::toModuleDTO).collect(Collectors.toList());
    }

    @GetMapping("/{moduleId}")
    public ModuleDTO getModuleById(@PathVariable Long moduleId) {
        return toModuleDTO(this.moduleService.getModuleById(moduleId));
    }

    private ModuleDTO toModuleDTO(Module module) {
        ModuleDTO moduleDTO = new ModuleDTO();
        if (module.getCourse() != null) {
            moduleDTO.setCourse(module.getCourse().getId());
        }
        List<Long> lecturesId = module.getLectures().stream().map(Lecture::getId).collect(Collectors.toList());
        moduleDTO.setLectures(lecturesId);
        moduleDTO.setId(module.getId());
        moduleDTO.setDurationInWeeks(module.getDurationInWeeks());
        moduleDTO.setName(module.getName());
        return moduleDTO;
    }
}
