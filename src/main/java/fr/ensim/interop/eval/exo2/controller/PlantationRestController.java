package fr.ensim.interop.eval.exo2.controller;

import fr.ensim.interop.eval.exo2.model.FakeBDD;
import fr.ensim.interop.eval.exo2.model.Plantation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@RestController
public class PlantationRestController {

    // TODO Exercice 2 - Implémentation d'une API REST pour la gestion de plantation

    /**
     * Requete POST qui créé une nouvelle plantation dans la base de donnée.
     *
     * @param date
     * @param parcelle
     * @param namePlant
     * @param familyPlant
     * @return id de la garantie créé
     */
    @PostMapping("/api/plantation")
    public ResponseEntity<Integer> addPlantation(@RequestParam("date") Calendar date,
                                                 @RequestParam("parcelle") String parcelle,
                                                 @RequestParam("namePlant") String namePlant,
                                                 @RequestParam("familyPlant") String familyPlant) {
        Plantation plantation = new Plantation(FakeBDD.seq.getAndIncrement(), date, parcelle, namePlant, familyPlant);
        FakeBDD.fakeBDD.put(plantation.getId(), plantation);

        System.out.println("Création d'une plantation");

        return ResponseEntity.ok().body(plantation.getId());
    }

    /**
     * Requete DELETE qui supprime une plantation en tapant l'ID spécifique
     *
     * @param id
     */

    @DeleteMapping("/api/plantation/{id}")
    public ResponseEntity<Plantation> dropPlantation(@PathVariable("id") int id) {
        if (FakeBDD.fakeBDD.containsKey(id)) {
            FakeBDD.fakeBDD.remove(id);
            System.out.println("Plantation avec l'ID n° " + id + " supprimée.");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Requete GET pour afficher toutes les plantations
     */
    @GetMapping("/api/plantation")
    public ResponseEntity<Collection<Plantation>> listPlantation() {
        System.out.println("Liste des plantations : \n");
        return ResponseEntity.ok().body(FakeBDD.fakeBDD.values());
    }

}