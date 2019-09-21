package application;
import javafx.application.*;     
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage; 
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JLabel;

public class Main extends Application {
	private static Stage s1;
	private static Stage s2;
	public ComboBox states;
	public TextField annualIncome;
	public void start(Stage s) throws FileNotFoundException {
		s1 = s;
		s2 = s;
		s.setTitle("Budgeting Calculator");
		//creating layout manager
				StackPane rootNode = new StackPane();
				rootNode.setPrefSize(500, 500);
		        
		        
		        final Text welcome = new Text("Welcome to a Financial Free Life!");
		        rootNode.getChildren().add(welcome);
		        welcome.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 30));
		        
		        final Text instructions = new Text("Please enter your state and yearly income");
		        
		        final Text state = new Text("State:");
		        state.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		        states = new ComboBox();
		        states.getItems().addAll(
		        		"Alabama","Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Folrida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kanasas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachussetts", "Michigan", "Minnesota", "Mississipi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermount", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
		        	);
		        final Text annualIncomet = new Text("Annual Income:");
		        annualIncomet.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		        annualIncome = new TextField();
		        Button submit = new Button("Submit");
		        
		        submit.setOnAction(new SubmitHandler());
		        
		        final Text key = new Text("Key:" + "\n" + "-Enter your annual income before tax" + "\n" + "");
		        key.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		        
		        state.setLayoutX(155);
		        state.setLayoutY(175);
		        state.setFill(Color.WHITE);
		        new AutoCompleteComboBoxListener<>(states);
		        
		        states.setLayoutX(240);
		        states.setLayoutY(145);
		        states.setPrefSize(200, 45);
		        
		        
		        submit.setLayoutX(230);
		        submit.setLayoutY(275);
		        submit.setPrefSize(220, 45);
		        
		        annualIncomet.setLayoutX(20);
		        annualIncomet.setLayoutY(235);
		        annualIncomet.setFill(Color.WHITE);
		        
		        annualIncome.setLayoutX(240);
		        annualIncome.setLayoutY(205);
		        annualIncome.setPrefSize(200, 45);
		        
		        
		        welcome.setLayoutX(20);
		        welcome.setLayoutY(40);
		        welcome.setFill(Color.WHITE);
		        
		        instructions.setLayoutX(115);
		        instructions.setLayoutY(130);
		        instructions.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		        instructions.setFill(Color.WHITE);
		        
		        key.setLayoutX(10);
		        key.setLayoutY(350);
		        
		        Group root = new Group(welcome, state, states, annualIncome, annualIncomet, instructions, submit, key);
		        
		        Scene scene = new Scene(root, 600, 390, Color.BLACK);
		        
				
				s.setScene(scene);
				s.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	class SubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			StackPane rootNode = new StackPane();
			final Text expenses = new Text("Expenses:");
			expenses.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
			expenses.setLayoutX(310);
			expenses.setLayoutY(30);
			expenses.setFill(Color.WHITE);
			
	        
			final Text expense1 = new Text("Housing: ");
	        expense1.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
	        expense1.setFill(Color.WHITE);
	        
	        final Text expense2 = new Text("Transportation: ");
	        expense2.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
	        expense2.setFill(Color.WHITE);
	        
	        final Text expense3 = new Text("Health: ");
	        expense3.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
	        expense3.setFill(Color.WHITE);
	        
	        final Text expense4 = new Text("Food: ");
	        expense4.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
	        expense4.setFill(Color.WHITE);
	        
	        final Text expense5 = new Text("Savings: ");
	        expense5.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
	        expense5.setFill(Color.WHITE);
	        
	        final Text expense6 = new Text("Leisure: ");
	        expense6.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
	        expense6.setFill(Color.WHITE);
	        
	        expense1.setLayoutX(180);
	        expense1.setLayoutY(140);
	        
	        expense2.setLayoutX(180);
	        expense2.setLayoutY(180);
	        
	        expense3.setLayoutX(180);
	        expense3.setLayoutY(220);
	        
	        expense4.setLayoutX(180);
	        expense4.setLayoutY(260);
	        
	        expense5.setLayoutX(180);
	        expense5.setLayoutY(300);
	        
	        expense6.setLayoutX(180);
	        expense6.setLayoutY(340);
			
	        TextField expenses1 = new TextField();
	        expenses1.setPrefSize(195, 35);
	        expenses1.setEditable(false);
	        
	        TextField expenses2 = new TextField();
	        expenses2.setPrefSize(195, 35);
	        expenses2.setEditable(false);
	        
	        TextField expenses3 = new TextField();
	        expenses3.setPrefSize(195, 35);
	        expenses3.setEditable(false);
	        
	        TextField expenses4 = new TextField();
	        expenses4.setPrefSize(195, 35);
	        expenses4.setEditable(false);
	        
	        TextField expenses5 = new TextField();
	        expenses5.setPrefSize(195, 35);
	        expenses5.setEditable(false);
	        
	        TextField expenses6 = new TextField();
	        expenses6.setPrefSize(195, 35);
	        expenses6.setEditable(false);
	        
	        expenses1.setLayoutX(400);
	        expenses1.setLayoutY(115);
	        
	        expenses2.setLayoutX(400);
	        expenses2.setLayoutY(155);
	        
	        expenses3.setLayoutX(400);
	        expenses3.setLayoutY(195);
	        
	        expenses4.setLayoutX(400);
	        expenses4.setLayoutY(235);
	        
	        expenses5.setLayoutX(400);
	        expenses5.setLayoutY(275);
	        
	        expenses6.setLayoutX(400);
	        expenses6.setLayoutY(315);
	        
	        String state = (String) states.getSelectionModel().getSelectedItem();
	        double percent = 0;
	        if(state.equals("Alaska")) {
	        	percent = 1.00;
	        }else if(state.equals("Arizona")) {
	        	percent = 1.03;
	        }else if(state.equals("Arkanas")) {

	            percent = 1.03;

	                
	        }else if(state.equals("California")) {

	            percent = .9;

	        }else if(state.equals("Colorado")) {

	            percent = .95;

	        }else if(state.equals("Connecticuit")) {

	            percent = .95;

	        }else if(state.equals("Delaware")) {

	            percent = .95;

	        }else if(state.equals("Florida")) {

	            percent = 1.00;

	        }else if(state.equals("Georgia")) {

	            percent = .96;

	        }else if(state.equals("Hawaii")) {

	            percent = .89;

	        }else if(state.equals("Idaho")) {

	            percent = .96;

	        }else if(state.equals("Illanois")) {

	            percent = .95;

	        }else if(state.equals("Indiana")) {

	            percent = .97;

	        }else if(state.equals("Iowa")) {

	            percent = .94;

	        }else if(state.equals("Kansas")) {

	            percent = .94;

	        }else if(state.equals("Kentucky")) {

	            percent = .95;

	        }else if(state.equals("Loiusiana")) {

	            percent = .95;

	        }else if(state.equals("Maine")) {

	            percent = .94;

	        }else if(state.equals("MaryLand")) {

	            percent = .95;

	        }else if(state.equals("Massachsets")) {

	            percent = .95;

	        }else if(state.equals("Mischigan")) {

	            percent = .96;

	        }else if(state.equals("Minisota")) {

	            percent = .94;

	        }else if(state.equals("Missouri")) {

	            percent = .95;

	        }else if(state.equals("Montana")) {

	            percent = .96;

	        }else if(state.equals("Nebraka")) {

	            percent = .94;

	        }else if(state.equals("Nevada")) {

	            percent = .99;

	        }else if(state.equals("New Hampshire")) {

	            percent = .95;

	        }else if(state.equals("New Jersey")) {

	            percent = .95;

	        }else if(state.equals("New Mexico")) {

	            percent = .97;

	        }else if(state.equals("New York")) {

	            percent = .94;

	        }else if(state.equals("North Carilona")) {

	            percent = 1.00;

	        }else if(state.equals("North Dakota")) {

	            percent = 0.98;

	        }else if(state.equals("Ohio")) {

	            percent = 0.95;

	        }

	        else if(state.equals("Oklahoma")) {

	            percent = 0.95;

	        }else if(state.equals("Oregon")) {

	            percent = 0.92;

	        }else if(state.equals("Pennsylvania")) {

	            percent = 0.92;

	        }else if(state.equals("Rode Island")) {

	            percent = 0.96;

	        }else if(state.equals("South Carolina")) {

	            percent = 0.95;

	        }else if(state.equals("South Dekota")) {

	            percent = 1.00;

	        }else if(state.equals("Tenesse")) {

	            percent = 0.94;

	        }else if(state.equals("Texas")) {

	            percent = 1.00;

	        }else if(state.equals("Utah")) {

	            percent = 0.95;

	        }else if(state.equals("Vermont")) {

	            percent = 0.93;

	        }else if(state.equals("Virginia")) {

	            percent = 0.96;

	        }

	        else if(state.equals("Washington")) {

	            percent = 1.00;

	        }else if(state.equals("West Virginia")) {

	            percent = 0.95;

	        }else if(state.equals("Wisconsin")) {

	            percent = 0.96;

	        }else if(state.equals("Wyoming")) {

	            percent = 1.00;

	        }else if(state.equals("Arizona")) {

	            percent = 1.03;

	        }else if(state.equals("Arizona")) {

	            percent = 1.03;
	        } else if (state.equals("Alabama")) {
	        	percent = 0.96;
	        }
	        
	        String secondIncome = (String) annualIncome.getText();
	        double secIncome = Double.parseDouble(secondIncome);
	        secIncome = secIncome * percent;
	        secIncome = secIncome/12;
	        
	        double Housing = secIncome * 0.3;
	        double Transportation = secIncome * 0.1;
	        double Health = secIncome * 0.05;
	        double Food = secIncome * 0.1;
	        double Savings = secIncome * 0.35;
	        double Leisure = secIncome * 0.1;
	        
	        DecimalFormat ft = new DecimalFormat("####");
	        
	        String f1 = ft.format(Housing);
	        String f2 = ft.format(Transportation);
	        String f3 = ft.format(Health);
	        String f4 = ft.format(Food);
	        String f5 = ft.format(Savings);
	        String f6 = ft.format(Leisure);
	        
	        expenses1.setText(f1);
	        expenses2.setText(f2);
	        expenses3.setText(f3);
	        expenses4.setText(f4);
	        expenses5.setText(f5);
	        expenses6.setText(f6);
	        
	        Button back = new Button("Back");
	        
	        rootNode.getChildren().add(back);
	        back.setLayoutX(600);
	        back.setLayoutY(380);
	        back.setPrefSize(140, 50);
	        
	        back.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
			    public void handle(ActionEvent e) {
	        		try {
						start(s2);
					} catch (FileNotFoundException e1) {
						
					}
	        	}
	        });
	        
			Group root = new Group(expenses, expense1, expense2, expense3, expense4, expense5, expense6, expenses1, expenses2, expenses3, expenses4, expenses5, expenses6, back);
			Scene scene1 = new Scene(root, 750, 450, Color.BLACK);
			
			Main.getStage1().setScene(scene1);
			
			s1.show();
		}
	}
	public static Stage getStage1() {
		// TODO Auto-generated method stub
		return s1;
	}
	public static Stage getStage2() {
		// TODO Auto-generated method stub
		return s2;
	}
}
