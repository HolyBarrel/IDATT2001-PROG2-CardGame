/**
 * Access module information for Cardgame
 * @author magnulal
 */
module edu.ntnu.idatt2001.magnulal.oblig3.cardgame.cardgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.ntnu.idatt2001.magnulal.oblig3.cardgame to javafx.fxml;
    exports edu.ntnu.idatt2001.magnulal.oblig3.cardgame;
    exports edu.ntnu.idatt2001.magnulal.oblig3.cardgame.view;
    opens edu.ntnu.idatt2001.magnulal.oblig3.cardgame.view to javafx.fxml;
    exports edu.ntnu.idatt2001.magnulal.oblig3.cardgame.controller;
    opens edu.ntnu.idatt2001.magnulal.oblig3.cardgame.controller to javafx.fxml;
    exports edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses;
}