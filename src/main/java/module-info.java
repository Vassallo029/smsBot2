module com.example.smsbot2 {
    requires javafx.controls;
    requires javafx.fxml;
    //requires com.fasterxml.jackson.annotation;
    requires twilio;

    opens com.example.smsbot2 to javafx.fxml;
    exports com.example.smsbot2;
}