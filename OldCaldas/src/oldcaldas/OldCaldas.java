/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldcaldas;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author utp
 */

public class OldCaldas {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Grafo viejoCaldas = new Grafo(53);
        CaminanteAgente caminante = new CaminanteAgente();

        //Risaralda
        Ciudad pereira = new Ciudad("Pereira", 4.814278, -75.694558);
        Ciudad dosquebradas = new  Ciudad("Dosquebradas", 4.836111, -75.676111);
        Ciudad marsella = new  Ciudad("Marsella" , 4.936667, -75.739167);
        Ciudad santaRosa = new  Ciudad("Santa Rosa de Cabal", 4.867222, -75.621111);
        Ciudad apia = new  Ciudad("Apia", 5.105278, -75.943333);
        Ciudad balboa = new  Ciudad("Balboa", 4.949444, -75.957222);
        Ciudad belenUmbria = new  Ciudad("Belen de Umbria", 5.200556, -75.868889);
        Ciudad guatica = new  Ciudad("Guatica", 5.316389, -75.798333);
        Ciudad laCelia = new  Ciudad("La Celia", 5.001944, -76.003889);
        Ciudad laVirginia = new  Ciudad("La Virginia", 4.896667, -75.883889);
        Ciudad quinchia = new  Ciudad("Quinchia", 5.339444, -75.729444);
        Ciudad santuario = new  Ciudad("Santuario", 5.074722, -75.964444);
        Ciudad mistrato = new Ciudad("Mistrato", 5.297778, -75.882778);
        Ciudad puebloRico = new Ciudad("Pueblo Rico", 5.222500, -76.88278);
        
        //Quindio
        Ciudad filandia = new Ciudad("Filandia", 4.673333, -75.658333);
        Ciudad salento = new Ciudad("Salento", 4.637222, -75.570833);
        Ciudad quimbaya = new Ciudad("Quimbaya", 4.637222, -75.763056);
        Ciudad circasia = new Ciudad("Circasia", 4.619167, -75.634722);
        Ciudad montenegro = new Ciudad("Montenegro", 4.565278, -75.751111);
        Ciudad armenia = new Ciudad("Armenia", 4.538889, -75.672500);
        Ciudad calarca = new Ciudad("Calarca", 4.529167, -75.640833);
        Ciudad laTebaida = new Ciudad("La Tebaida", 4.452222, -75.786667);
        Ciudad cordoba = new Ciudad("Cordoba", 4.391111, -75.687778);
        Ciudad buenavista = new Ciudad("Buenavista", 4.359722, -75.739157);
        Ciudad pijao = new Ciudad("Pijao", 4.332778, -75.705556);       
        Ciudad genova = new Ciudad("Genova", 4.207500, -75.790000);
        
        //Caldas
        Ciudad filadelfia = new Ciudad("Filadelfia", 5.296111, -75.561667);
        Ciudad laMerced = new Ciudad("La Merced", 5.399444, -75.546944);
        Ciudad marmato = new Ciudad("Marmato", 5.475278, -75.599167);
        Ciudad riosucio = new Ciudad("Riosucio", 5.420833, -75.702778);
        Ciudad supia = new Ciudad("Supia", 5.450556, -75.651389);
        Ciudad manzanares = new Ciudad("Manzanares", 5.251944, -75.156944);
        Ciudad marquetalia = new Ciudad("Marquetalia", 5.296944, -75.053056);
        Ciudad marulanda= new Ciudad("Marulanda", 5.284167, -75.260278);
        Ciudad pensilvania = new Ciudad("Pensilvania", 5.383611, -75.163333);
        Ciudad anserma = new Ciudad("Anserma", 5.238092, -75.784042);
        Ciudad belalcazar = new Ciudad("Belalcazar", 4.993611, -75.811944);
        Ciudad risaralda = new Ciudad("Risaralda", 5.163889, -75.767222);
        Ciudad sanJose = new Ciudad("San Jose", 5.090000, -75.790000);
        Ciudad viterbo = new Ciudad("Viterbo", 5.060556, -75.8873333);
        Ciudad chinchina = new Ciudad("Chinchina", 4.980556, -75.607500);
        Ciudad manizales = new Ciudad("Manizales", 5.066111, -75.484722);
        Ciudad neira = new Ciudad("Neira", 5.166389, -75.518889);
        Ciudad palestina = new Ciudad("Palestina", 5.019444, -75.623333);
        Ciudad villamaria = new Ciudad("Villamaria", 5.045556, -75.515278);
        Ciudad laDorada = new Ciudad("La Dorada", 5.453839, -74.664675);
        Ciudad norcasia = new Ciudad("Norcasia", 5.574167, -78.888889);
        Ciudad samana = new Ciudad("Samana", 5.413056, -74.992778);
        Ciudad victoria = new Ciudad("Victoria", 5.316389, -74.912500);
        Ciudad aguadas = new Ciudad("Aguadas", 5.609167, -75.456389);
        Ciudad aranzazu = new Ciudad("Aranzazu", 5.271389, -75.490833);
        Ciudad pacora = new Ciudad("Pacora", 5.525833, -75.458889);
        Ciudad salamina = new Ciudad("Salamina", 5.408056, -75.487778);
        
        

        //Risaralda
        viejoCaldas.setLabel(0, pereira.getNombre());
        viejoCaldas.setLabel(1, dosquebradas.getNombre());
        viejoCaldas.setLabel(2, marsella.getNombre());
        viejoCaldas.setLabel(3, santaRosa.getNombre());
        viejoCaldas.setLabel(4, apia.getNombre());
        viejoCaldas.setLabel(5, balboa.getNombre());
        viejoCaldas.setLabel(6, belenUmbria.getNombre());
        viejoCaldas.setLabel(7, guatica.getNombre());
        viejoCaldas.setLabel(8, laCelia.getNombre());
        viejoCaldas.setLabel(9, laVirginia.getNombre());
        viejoCaldas.setLabel(10, quinchia.getNombre());
        viejoCaldas.setLabel(11, santuario.getNombre());
        viejoCaldas.setLabel(12, mistrato.getNombre());
        viejoCaldas.setLabel(13, puebloRico.getNombre());
        
        //Quindio
        viejoCaldas.setLabel(14, filandia.getNombre());
        viejoCaldas.setLabel(15, salento.getNombre());
        viejoCaldas.setLabel(16, quimbaya.getNombre());
        viejoCaldas.setLabel(17, circasia.getNombre());
        viejoCaldas.setLabel(18, montenegro.getNombre());
        viejoCaldas.setLabel(19, armenia.getNombre());
        viejoCaldas.setLabel(20, calarca.getNombre());
        viejoCaldas.setLabel(21, laTebaida.getNombre());
        viejoCaldas.setLabel(22, cordoba.getNombre());
        viejoCaldas.setLabel(23, buenavista.getNombre());
        viejoCaldas.setLabel(24, pijao.getNombre());
        viejoCaldas.setLabel(25, genova.getNombre());
        
        //Caldas
        viejoCaldas.setLabel(26, filadelfia.getNombre());
        viejoCaldas.setLabel(27, laMerced.getNombre());
        viejoCaldas.setLabel(28, marmato.getNombre());
        viejoCaldas.setLabel(29, riosucio.getNombre());
        viejoCaldas.setLabel(30, supia.getNombre());
        viejoCaldas.setLabel(31, manzanares.getNombre());
        viejoCaldas.setLabel(32, marulanda.getNombre());
        viejoCaldas.setLabel(33, pensilvania.getNombre());
        viejoCaldas.setLabel(34, anserma.getNombre());
        viejoCaldas.setLabel(35, belalcazar.getNombre());
        viejoCaldas.setLabel(36, risaralda.getNombre());
        viejoCaldas.setLabel(37, sanJose.getNombre());
        viejoCaldas.setLabel(38, viterbo.getNombre());
        viejoCaldas.setLabel(39, chinchina.getNombre());
        viejoCaldas.setLabel(40, manizales.getNombre());
        viejoCaldas.setLabel(41, neira.getNombre());
        viejoCaldas.setLabel(42, palestina.getNombre());
        viejoCaldas.setLabel(43, villamaria.getNombre());
        viejoCaldas.setLabel(44, laDorada.getNombre());
        viejoCaldas.setLabel(45, norcasia.getNombre());
        viejoCaldas.setLabel(46, victoria.getNombre());
        viejoCaldas.setLabel(47, aguadas.getNombre());
        viejoCaldas.setLabel(48, aranzazu.getNombre());
        viejoCaldas.setLabel(49, pacora.getNombre());
        viejoCaldas.setLabel(50, salamina.getNombre());
        viejoCaldas.setLabel(51, marquetalia.getNombre());
        viejoCaldas.setLabel(52, samana.getNombre());
        
        viejoCaldas.addEgdeString(laVirginia.getNombre() , belalcazar.getNombre(), laVirginia.getLongitud(), laVirginia.getLatitud(), belalcazar.getLongitud(), belalcazar.getLatitud());
        viejoCaldas.addEgdeString(laVirginia.getNombre(), apia.getNombre(), laVirginia.getLongitud(), laVirginia.getLatitud(), apia.getLongitud(), apia.getLatitud());
        viejoCaldas.addEgdeString(laVirginia.getNombre(), balboa.getNombre(), laVirginia.getLongitud(), laVirginia.getLatitud(), balboa.getLongitud(), balboa.getLatitud());
        viejoCaldas.addEgdeString(laVirginia.getNombre(), viterbo.getNombre(), laVirginia.getLongitud(), laVirginia.getLatitud(), viterbo.getLongitud(), viterbo.getLatitud());
        viejoCaldas.addEgdeString(laVirginia.getNombre(), santuario.getNombre(), laVirginia.getLongitud(), laVirginia.getLatitud(), santuario.getLongitud(), santuario.getLatitud());
        viejoCaldas.addEgdeString(laVirginia.getNombre(), anserma.getNombre(), laVirginia.getLongitud(), laVirginia.getLatitud(), anserma.getLongitud(), anserma.getLatitud());
        viejoCaldas.addEgdeString(laVirginia.getNombre(), pereira.getNombre(), laVirginia.getLongitud(), laVirginia.getLatitud(), pereira.getLongitud(), pereira.getLatitud());
        viejoCaldas.addEgdeString(laVirginia.getNombre(), belenUmbria.getNombre(), laVirginia.getLongitud(), laVirginia.getLatitud(), belenUmbria.getLongitud(), belenUmbria.getLatitud());
        viejoCaldas.addEgdeString(balboa.getNombre(), laCelia.getNombre(), balboa.getLongitud(), balboa.getLatitud(), laCelia.getLongitud(), laCelia.getLatitud());
        viejoCaldas.addEgdeString(laCelia.getNombre(), santuario.getNombre(), laCelia.getLongitud(), laCelia.getLatitud(), santuario.getLongitud(), santuario.getLatitud());
        viejoCaldas.addEgdeString(apia.getNombre(), viterbo.getNombre(), apia.getLongitud(), apia.getLatitud(), viterbo.getLongitud(), viterbo.getLatitud());
        viejoCaldas.addEgdeString(apia.getNombre(), puebloRico.getNombre(), apia.getLongitud(), apia.getLatitud(), puebloRico.getLongitud(), puebloRico.getLatitud());
        viejoCaldas.addEgdeString(belenUmbria.getNombre(), mistrato.getNombre(), belenUmbria.getLongitud(), belenUmbria.getLatitud(), mistrato.getLongitud(), mistrato.getLatitud());
        viejoCaldas.addEgdeString(mistrato.getNombre(), guatica.getNombre(), mistrato.getLongitud(), mistrato.getLatitud(), guatica.getLongitud(), guatica.getLatitud());
        viejoCaldas.addEgdeString(anserma.getNombre(), guatica.getNombre(), anserma.getLongitud(), anserma.getLatitud(), guatica.getLongitud(), guatica.getLatitud());
        viejoCaldas.addEgdeString(anserma.getNombre(), quinchia.getNombre(), anserma.getLongitud(), anserma.getLatitud(), quinchia.getLongitud(), quinchia.getLatitud());
        viejoCaldas.addEgdeString(anserma.getNombre(), risaralda.getNombre(), anserma.getLongitud(), anserma.getLatitud(), risaralda.getLongitud(), risaralda.getLatitud());
        viejoCaldas.addEgdeString(anserma.getNombre(), riosucio.getNombre(), anserma.getLongitud(), anserma.getLatitud(), riosucio.getLongitud(), riosucio.getLatitud());
        viejoCaldas.addEgdeString(viterbo.getNombre(), sanJose.getNombre(), viterbo.getLongitud(), viterbo.getLatitud(), sanJose.getLongitud(), sanJose.getLatitud());
        viejoCaldas.addEgdeString(sanJose.getNombre(), belalcazar.getNombre(), sanJose.getLongitud(), sanJose.getLatitud(), belalcazar.getLongitud(), belalcazar.getLatitud());
        viejoCaldas.addEgdeString(riosucio.getNombre(), supia.getNombre(), riosucio.getLongitud(), riosucio.getLatitud(), supia.getLongitud(), supia.getLatitud());
        viejoCaldas.addEgdeString(supia.getNombre(), marmato.getNombre(), supia.getLongitud(), supia.getLatitud(), marmato.getLongitud(), marmato.getLatitud());
        viejoCaldas.addEgdeString(supia.getNombre(), laMerced.getNombre(), supia.getLongitud(), supia.getLatitud(), laMerced.getLongitud(), laMerced.getLatitud());
        viejoCaldas.addEgdeString(supia.getNombre(), pacora.getNombre(), supia.getLongitud(), supia.getLatitud(), pacora.getLongitud(), pacora.getLatitud());
        viejoCaldas.addEgdeString(pacora.getNombre(), aguadas.getNombre(), pacora.getLongitud(), pacora.getLatitud(), aguadas.getLongitud(), aguadas.getLatitud());
        viejoCaldas.addEgdeString(laMerced.getNombre(), salamina.getNombre(), laMerced.getLongitud(), laMerced.getLatitud(), salamina.getLongitud(), salamina.getLatitud());
        viejoCaldas.addEgdeString(salamina.getNombre(), pacora.getNombre(), salamina.getLongitud(), salamina.getLatitud(), pacora.getLongitud(), pacora.getLatitud());
        viejoCaldas.addEgdeString(laMerced.getNombre(), filadelfia.getNombre(), laMerced.getLongitud(), laMerced.getLatitud(), filadelfia.getLongitud(), filadelfia.getLatitud());
        viejoCaldas.addEgdeString(supia.getNombre(), filadelfia.getNombre(), supia.getLongitud(), supia.getLatitud(), filadelfia.getLongitud(), filadelfia.getLatitud());
        viejoCaldas.addEgdeString(filadelfia.getNombre(), aranzazu.getNombre(), filadelfia.getLongitud(), filadelfia.getLatitud(), aranzazu.getLongitud(), aranzazu.getLatitud());
        viejoCaldas.addEgdeString(aranzazu.getNombre(), salamina.getNombre(), aranzazu.getLongitud(), aranzazu.getLatitud(), salamina.getLongitud(), salamina.getLatitud());
        viejoCaldas.addEgdeString(aranzazu.getNombre(), marulanda.getNombre(), aranzazu.getLongitud(), aranzazu.getLatitud(), marulanda.getLongitud(), marulanda.getLatitud());
        viejoCaldas.addEgdeString(aranzazu.getNombre(), neira.getNombre(), aranzazu.getLongitud(), aranzazu.getLatitud(), neira.getLongitud(), neira.getLatitud());
        viejoCaldas.addEgdeString(manzanares.getNombre(), marulanda.getNombre(), manzanares.getLongitud(), manzanares.getLatitud(), marulanda.getLongitud(), marulanda.getLatitud());
        viejoCaldas.addEgdeString(risaralda.getNombre(), palestina.getNombre(), risaralda.getLongitud(), risaralda.getLatitud(), palestina.getLongitud(), palestina.getLatitud());
        viejoCaldas.addEgdeString(neira.getNombre(), manizales.getNombre(), neira.getLongitud(), neira.getLatitud(), manizales.getLongitud(), manizales.getLatitud());
        viejoCaldas.addEgdeString(manizales.getNombre(), palestina.getNombre(), manizales.getLongitud(), manizales.getLatitud(), palestina.getLongitud(), palestina.getLatitud());
        viejoCaldas.addEgdeString(manizales.getNombre(), chinchina.getNombre(), manizales.getLongitud(), manizales.getLatitud(), chinchina.getLongitud(), chinchina.getLatitud());
        viejoCaldas.addEgdeString(chinchina.getNombre(), santaRosa.getNombre(), chinchina.getLongitud(), chinchina.getLatitud(), santaRosa.getLongitud(), santaRosa.getLatitud());
        viejoCaldas.addEgdeString(pereira.getNombre(), dosquebradas.getNombre(), pereira.getLongitud(), pereira.getLatitud(), dosquebradas.getLongitud(), dosquebradas.getLatitud());
        viejoCaldas.addEgdeString(dosquebradas.getNombre(), santaRosa.getNombre(), dosquebradas.getLongitud(), dosquebradas.getLatitud(), santaRosa.getLongitud(), santaRosa.getLatitud());
        viejoCaldas.addEgdeString(pereira.getNombre(), marsella.getNombre(), pereira.getLongitud(), pereira.getLatitud(), marsella.getLongitud(), marsella.getLatitud());
        viejoCaldas.addEgdeString(quimbaya.getNombre(), montenegro.getNombre(), quimbaya.getLongitud(), quimbaya.getLatitud(), montenegro.getLongitud(), montenegro.getLatitud());
        viejoCaldas.addEgdeString(montenegro.getNombre(), armenia.getNombre(), montenegro.getLongitud(), montenegro.getLatitud(), armenia.getLongitud(), armenia.getLatitud());
        viejoCaldas.addEgdeString(quimbaya.getNombre(), filandia.getNombre(), quimbaya.getLongitud(), quimbaya.getLatitud(), filandia.getLongitud(), filandia.getLatitud());
        viejoCaldas.addEgdeString(pereira.getNombre(), salento.getNombre(), pereira.getLongitud(), pereira.getLatitud(), salento.getLongitud(), salento.getLatitud());
        viejoCaldas.addEgdeString(salento.getNombre(), armenia.getNombre(), salento.getLongitud(), salento.getLatitud(), armenia.getLongitud(), armenia.getLatitud());
        viejoCaldas.addEgdeString(filandia.getNombre(), salento.getNombre(), filandia.getLongitud(), filandia.getLatitud(), salento.getLongitud(), salento.getLatitud());
        viejoCaldas.addEgdeString(armenia.getNombre(), calarca.getNombre(), armenia.getLongitud(), armenia.getLatitud(), calarca.getLongitud(), calarca.getLatitud());
        viejoCaldas.addEgdeString(calarca.getNombre(), salento.getNombre(), calarca.getLongitud(), calarca.getLatitud(), salento.getLongitud(), salento.getLatitud());
        viejoCaldas.addEgdeString(calarca.getNombre(), cordoba.getNombre(), calarca.getLongitud(), calarca.getLatitud(), cordoba.getLongitud(), cordoba.getLatitud());
        viejoCaldas.addEgdeString(cordoba.getNombre(), pijao.getNombre(), cordoba.getLongitud(), cordoba.getLatitud(), pijao.getLongitud(), pijao.getLatitud());
        viejoCaldas.addEgdeString(cordoba.getNombre(), buenavista.getNombre(), cordoba.getLongitud(), cordoba.getLatitud(), buenavista.getLongitud(), buenavista.getLatitud());
        viejoCaldas.addEgdeString(buenavista.getNombre(), pijao.getNombre(), buenavista.getLongitud(), buenavista.getLatitud(), pijao.getLongitud(), pijao.getLatitud());
        viejoCaldas.addEgdeString(buenavista.getNombre(), genova.getNombre(), buenavista.getLongitud(), buenavista.getLatitud(), genova.getLongitud(), genova.getLatitud());
        viejoCaldas.addEgdeString(genova.getNombre(), pijao.getNombre(), genova.getLongitud(), genova.getLatitud(), pijao.getLongitud(), pijao.getLatitud());
        viejoCaldas.addEgdeString(laTebaida.getNombre(), armenia.getNombre(), laTebaida.getLongitud(), laTebaida.getLatitud(), armenia.getLongitud(), armenia.getLatitud());
        viejoCaldas.addEgdeString(laTebaida.getNombre(), montenegro.getNombre(), laTebaida.getLongitud(), laTebaida.getLatitud(), montenegro.getLongitud(), montenegro.getLatitud());
        viejoCaldas.addEgdeString(manzanares.getNombre(), pensilvania.getNombre(), manzanares.getLongitud(), manzanares.getLatitud(), pensilvania.getLongitud(), pensilvania.getLatitud());
        viejoCaldas.addEgdeString(manzanares.getNombre(), marquetalia.getNombre(), manzanares.getLongitud(), manzanares.getLatitud(), marquetalia.getLongitud(), marquetalia.getLatitud());
        viejoCaldas.addEgdeString(marquetalia.getNombre(), victoria.getNombre(), marquetalia.getLongitud(), marquetalia.getLatitud(), victoria.getLongitud(), victoria.getLatitud());
        viejoCaldas.addEgdeString(marquetalia.getNombre(), samana.getNombre(), marquetalia.getLongitud(), marquetalia.getLatitud(), samana.getLongitud(), samana.getLatitud());
        viejoCaldas.addEgdeString(samana.getNombre(), pensilvania.getNombre(), samana.getLongitud(), samana.getLatitud(), pensilvania.getLongitud(), pensilvania.getLatitud());
        viejoCaldas.addEgdeString(victoria.getNombre(), samana.getNombre(), victoria.getLongitud(), victoria.getLatitud(), samana.getLongitud(), samana.getLatitud());
        viejoCaldas.addEgdeString(samana.getNombre(), norcasia.getNombre(), samana.getLongitud(), samana.getLatitud(), norcasia.getLongitud(), norcasia.getLatitud());
        viejoCaldas.addEgdeString(victoria.getNombre(), norcasia.getNombre(), victoria.getLongitud(), victoria.getLatitud(), norcasia.getLongitud(), norcasia.getLatitud());
        viejoCaldas.addEgdeString(victoria.getNombre(), laDorada.getNombre(), victoria.getLongitud(), victoria.getLatitud(), laDorada.getLongitud(), laDorada.getLatitud());
        viejoCaldas.addEgdeString(manizales.getNombre(), villamaria.getNombre(), manizales.getLongitud(), manizales.getLatitud(), villamaria.getLongitud(), villamaria.getLatitud());
        viejoCaldas.addEgdeString(circasia.getNombre(), armenia.getNombre(), circasia.getLongitud(), circasia.getLatitud(), armenia.getLongitud(), armenia.getLatitud());
        viejoCaldas.addEgdeString(circasia.getNombre(), salento.getNombre(), circasia.getLongitud(), circasia.getLatitud(), salento.getLongitud(), salento.getLatitud());
        viejoCaldas.addEgdeString(circasia.getNombre(), montenegro.getNombre(), circasia.getLongitud(), circasia.getLatitud(), montenegro.getLongitud(), montenegro.getLatitud());
        viejoCaldas.addEgdeString(circasia.getNombre(), filandia.getNombre(), circasia.getLongitud(), circasia.getLatitud(), filandia.getLongitud(), filandia.getLatitud());
        viejoCaldas.addEgdeString(circasia.getNombre(), pereira.getNombre(), circasia.getLongitud(), circasia.getLatitud(), pereira.getLongitud(), pereira.getLatitud());        
        viejoCaldas.display();     
        caminante.execute("BFS", viejoCaldas, laVirginia.getNombre(), laDorada.getNombre());
        caminante.execute("DFS", viejoCaldas, laVirginia.getNombre(), laDorada.getNombre());
    }
    
}