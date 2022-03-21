/**
 * TODO:COMMENT
 */
module edu.ntnu.idatt2001.magnulal.oblig3.cardgame.cardgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.ntnu.idatt2001.magnulal.oblig3.cardgame to javafx.fxml;
    exports edu.ntnu.idatt2001.magnulal.oblig3.cardgame;
}