package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FermoDeposito {
    private final int capacitaMassima;
    private final List<Collo> giacenze;

    public FermoDeposito(int capacitaMassima) {
        this.capacitaMassima = capacitaMassima;
        this.giacenze = new ArrayList<>();
    }

    public boolean deposita(Collo collo) {
        if (collo == null || giacenze.size() >= capacitaMassima) {
            return false;
        }
        return giacenze.add(collo);
    }
    
    //usiamo Optional per gestire il caso in cui non ci sia un collo con quel seriale ed
    //evitare di restituire null, che potrebbe generare NullPointerException
    
    public Optional<Collo> prelevaPerSeriale(String seriale) {
        if (giacenze.isEmpty() || seriale == null) {
            return Optional.empty();
        }
        for (int i = 0; i < giacenze.size(); i++) {
            if (giacenze.get(i).getCodiceSeriale().equalsIgnoreCase(seriale)) {
     //prende il CodiceSeriale dell'elemento i e lo confronta con il codice seriale inserito(come lo vedremo)
                return Optional.of(giacenze.remove(i));  //siamo sicuri che rimuovo un oggetto quindi uso of
            }
        }
        return Optional.empty();
    }

    
     // Filtra i pacchi per seriale o marca 
    
    public List<Collo> filtra(String testoFiltro) {
        if (testoFiltro == null || testoFiltro.isBlank()) {
            return getGiacenze(); // Restituisce una copia della lista originale se il filtro è vuoto o nullo
        }
        String filtro = testoFiltro.toLowerCase();
        //lo stream serve a filtrare la lista giacenze, confrontando il codice seriale e la marca con il filtro inserito
        return giacenze.stream()
                .filter(collo -> collo.getCodiceSeriale().toLowerCase().contains(filtro)
                          || collo.getMarca().toLowerCase().contains(filtro))
                .collect(Collectors.toList());
    }

    public List<Collo> getGiacenze() {
        return Collections.unmodifiableList(giacenze);
    }

    public int getNumeroColli() {
        return giacenze.size();
    }
}