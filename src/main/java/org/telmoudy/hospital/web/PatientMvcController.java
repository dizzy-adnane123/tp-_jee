package org.telmoudy.hospital.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.telmoudy.hospital.entities.Patient;
import org.telmoudy.hospital.services.PatientService;


@Controller
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientMvcController {

    PatientService patientService;
    @GetMapping(path = "")
    public String patients2(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue = "") String keyword
    ){
        Page<Patient> pagePatients= this.patientService.getPatientByReference(keyword,page,size);
        model.addAttribute("patients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return "patient/index";
    }

    @GetMapping(path = "/")
    public String patients(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue = "") String keyword
    ){
        Page<Patient> pagePatients= this.patientService.getPatientByReference(keyword,page,size);
        model.addAttribute("patients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return "patient/index";
    }

    @GetMapping("delete")
    public RedirectView delete(Long id, String keyword, int page) {
        patientService.deletePatient(id);
        return new RedirectView("?page="+page+"&keyword="+keyword, true);
     //   return "redirect:patient?page="+page+"&keyword="+keyword;
    }
}