package pl.kz.championshipsfootballapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kz.championshipsfootballapp.model.Grupy;
import pl.kz.championshipsfootballapp.repo.GrupyRepository;

/**
 * Created by JACZAW on 21.07.2018.
 */
@Controller
public class GrupyRestController {
   
    @RequestMapping("/create")
    @ResponseBody
    public String create(Long id, String nazwa) {
        Grupy grupy = null;
        try {
            grupy = new Grupy(id,nazwa);
            grupyRepository.save(grupy);
        }
        catch (Exception ex) {
            return "Blad tworzenia grupyr: " + ex.toString();
        }
        return "Grupa poprawnie utworzona! (id = " + grupy.getId() + ")";
    }

    /**
     * /delete  --> Delete the grupy having the passed id.
     *
     * @param id The id of the grupy to delete
     * @return A string describing if the grupy is successfully deleted or not.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Grupy grupy = new Grupy(id);
            GrupyRepository.delete(grupy);
        }
        catch (Exception ex) {
            return "Error deleting the grupy: " + ex.toString();
        }
        return "Grupy successfully deleted!";
    }


    @RequestMapping("/get-by-nazwa")
    @ResponseBody
    public String getByEmail(String nazwa) {
        String grupyId;
        try {
            Grupy grupy = GrupyRepository.findByNazwa(nazwa);
            grupyId = String.valueOf(grupy.getId());
        }
        catch (Exception ex) {
            return "Grupy not found";
        }
        return "The grupy id is: " + grupyId;
    }


    @RequestMapping("/update")
    @ResponseBody
    public String updateGrupy(long id, String nazwa) {
        try {
            Grupy grupy = GrupyRepository.findOne(id);
            grupy.getNazwa();
            GrupyRepository.save(grupy);
        }
        catch (Exception ex) {
            return "Error updating the grupy: " + ex.toString();
        }
        return "Grupy successfully updated!";
    }

    @Autowired
    private GrupyRepository grupyRepository;
}
