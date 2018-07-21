package pl.kz.championshipsfootballapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kz.championshipsfootballapp.model.Kluby;
import pl.kz.championshipsfootballapp.repo.KlubyRepository;

/**
 * Created by JACZAW on 21.07.2018.
 */
@Controller
public class KlubyRestController {
   
    @RequestMapping("/create")
    @ResponseBody
    public String create(Long id, String nazwa) {
        Kluby kluby = null;
        try {
            kluby = new Kluby(id,nazwa);
            klubyRepository.save(kluby);
        }
        catch (Exception ex) {
            return "Blad tworzenia kluby: " + ex.toString();
        }
        return "Klub poprawnie utworzony! (id = " + kluby.getId() + ")";
    }

    /**
     * /delete  --> Delete the kluby having the passed id.
     *
     * @param id The id of the kluby to delete
     * @return A string describing if the kluby is successfully deleted or not.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Kluby kluby = new Kluby(id);
            klubyRepository.delete(kluby);
        }
        catch (Exception ex) {
            return "Error deleting the kluby: " + ex.toString();
        }
        return "Kluby successfully deleted!";
    }


    @RequestMapping("/get-by-nazwa")
    @ResponseBody
    public String getByNazwa(String nazwa) {
        String klubyId;
        try {
            Kluby kluby = klubyRepository.findByNazwa(nazwa);
            klubyId = String.valueOf(kluby.getId());
        }
        catch (Exception ex) {
            return "Kluby not found";
        }
        return "The kluby id is: " + klubyId;
    }


    @RequestMapping("/update")
    @ResponseBody
    public String updateKluby(long id, String nazwa) {
        try {
            Kluby kluby = klubyRepository.findOne(id);
            kluby.getNazwa();
            klubyRepository.save(kluby);
        }
        catch (Exception ex) {
            return "Error updating the kluby: " + ex.toString();
        }
        return "Kluby successfully updated!";
    }

    @Autowired
    private KlubyRepository klubyRepository;
}
