package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

class Helse {

    public static String beregnHelse(String navn, double vekt, double høyde, int fødselsår) {

        double BMI = vekt / (høyde * høyde);
        String ut = "";
        /*
        < 18 – undervektig
      >= 18 og < 25 – normalvektig
       >= 25 og < 30 – overvektig
        >= 30 – fet.
         */

        if (BMI < 18) {
            ut = "undervektig";
        } else if (BMI >= 18 && BMI < 25) {
            ut = "normalvektig";
        } else if (BMI >= 25 && BMI < 30) {
            ut = "overvektig";
        } else if (BMI >= 30) {
            ut = "fet";
        }
        int alder = 2020 - fødselsår;
        int min_frekvens = (int) Math.round((220 - alder) * 0.5);
        int maks_frekvens = (int) Math.round((220 - alder) * 0.85);

        return navn + " født " + fødselsår + " er " + ut + "\n" + "Hjertefrekvens bør ligge mellom " + min_frekvens + " og " + maks_frekvens;
    }

}

public class Controller {
    @FXML
    private TextField txtNavn;
    @FXML
    private TextField txtFødt;
    @FXML
    private TextField txtHøyde;
    @FXML
    private TextField txtVekt;
    @FXML
    private Label lblResultat;

    @FXML
    void beregn(ActionEvent event) {

        // din kode her
        String innNavn = txtNavn.getText();
        String innFødt = txtFødt.getText();
        String innHøyde = txtHøyde.getText();
        String innVekt = txtVekt.getText();

        double vekt, høyde;
        int født;
        try {
            vekt = Double.parseDouble(innVekt);
            høyde = Double.parseDouble(innHøyde);
            født = Integer.parseInt(innFødt);
            //aasda

        } catch (Exception e) {
            vekt = 0;
            høyde = 0;
            født = 0;
            lblResultat.setText("Du har skrevet ugyldig data");
        }
        String result = Helse.beregnHelse(innNavn, vekt, høyde, født);


        if (født != 0 || høyde != 0 || vekt != 0) {
            lblResultat.setText(result);
        }

    }
}