package com.herbie.sc.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herbie.sc.data.models.Client;
import com.herbie.sc.data.repositories.ClientRepository;
import com.herbie.sc.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping ("/client")
public class herbieController {

    @Autowired
    private final ClientRepository clientRepository;

    @Autowired
    private final ClientService clientService;

    public herbieController (ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @GetMapping
    public String index() {
        return "/client/index.html";
    }
    @RequestMapping(value = "/data_for_datatable", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getDataForDatatable(@RequestParam Map<String, Object> params) {
        int draw = params.containsKey("draw") ? Integer.parseInt(params.get("draw").toString()) : 1;
        int length = params.containsKey("length") ? Integer.parseInt(params.get("length").toString()) : 30;
        int start = params.containsKey("start") ? Integer.parseInt(params.get("start").toString()) : 30;
        int currentPage = start / length;

        String sortName = "id";
        String dataTableOrderColumnIdx = params.get("order[0][column]").toString();
        String dataTableOrderColumnName = "columns[" + dataTableOrderColumnIdx + "][data]";
        if (params.containsKey(dataTableOrderColumnName))
            sortName = params.get(dataTableOrderColumnName).toString();
        String sortDir = params.containsKey("order[0][dir]") ? params.get("order[0][dir]").toString() : "asc";

        Sort.Order sortOrder = new Sort.Order((sortDir.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC), sortName);
        Sort sort = Sort.by(sortOrder);

        Pageable pageRequest = PageRequest.of(currentPage,
                length,
                sort);

        String queryString = (String) (params.get("search[value]"));

        Page<Client> clients = clientService.getClientsForDatatable(queryString, pageRequest);

        long totalRecords = clients.getTotalElements();

        List<Map<String, Object>> cells = new ArrayList<>();
        clients.forEach(client -> {
            Map<String, Object> cellData = new HashMap<>();
            cellData.put("id", client.getId());
            cellData.put("firstName", client.getFirstName());
            cellData.put("lastName", client.getLastName());
            cellData.put("emailAddress", client.getEmailAddress());
            cellData.put("city", client.getCity());
            cellData.put("country", client.getCountry());
            cellData.put("phoneNumber", client.getPhoneNumber());
            cells.add(cellData);
        });

        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("draw", draw);
        jsonMap.put("recordsTotal", totalRecords);
        jsonMap.put("recordsFiltered", totalRecords);
        jsonMap.put("data", cells);

        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(jsonMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Client clientInstance = clientRepository.findById(Long.valueOf(id)).get();

        model.addAttribute("clientInstance", clientInstance);

        return "/client/edit.html";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("clientInstance") Client clientInstance,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes atts) {
        if (bindingResult.hasErrors()) {
            return "/client/edit.html";
        } else {
            if (clientRepository.save(clientInstance) != null)
                atts.addFlashAttribute("message", "Client's Information updated successfully");
            else
                atts.addFlashAttribute("message", "Unable to update Client's information.");

            return "redirect:/client/";
        }
    }

    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("clientInstance", new Client());
        return "/client/create.html";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("clientInstance") Client clientInstance,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes atts) {
        if (bindingResult.hasErrors()) {
            return "/client/create.html";
        } else {
            if (clientRepository.save(clientInstance) != null)
                atts.addFlashAttribute("message", "Client created successfully");
            else
                atts.addFlashAttribute("message", "Client creation failed.");

            return "redirect:/client/";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes atts) {
        Client clientInstance = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client Not Found:" + id));

        clientRepository.delete(clientInstance);

        atts.addFlashAttribute("message", "Client deleted.");

        return "redirect:/client/";
    }
}