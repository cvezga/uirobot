package com.gft.automate;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DecorationTest extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		 

		Group root = new Group();
		//Scene scene = new Scene(root, 500, 200);

		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		// set Stage boundaries to visible bounds of the main screen
		primaryStage.setX(primaryScreenBounds.getMinX());
		primaryStage.setY(primaryScreenBounds.getMinY());
		primaryStage.setWidth(primaryScreenBounds.getWidth());
		primaryStage.setHeight(primaryScreenBounds.getHeight());

		Canvas canvas = new Canvas(primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
		
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawShapes(gc);
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

		canvas.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				double x = event.getX();
				double y = event.getY();
				
				 gc.fillArc(x,y, 30, 30, 45, 240, ArcType.OPEN);
				
			}

			
		});
		
		//primaryStage.setScene(scene);
		//primaryStage.show();
	}
	
	 private void drawShapes(GraphicsContext gc) {
	        gc.setFill(Color.GREEN);
	        gc.setStroke(Color.BLUE);
	        gc.setLineWidth(5);
	        gc.strokeLine(40, 10, 10, 40);
	        gc.fillOval(10, 60, 30, 30);
	        gc.strokeOval(60, 60, 30, 30);
	        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
	        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
	        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
	        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
	        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
	        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
	        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
	        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
	        gc.fillPolygon(new double[]{10, 40, 10, 40},
	                       new double[]{210, 210, 240, 240}, 4);
	        gc.strokePolygon(new double[]{60, 90, 60, 90},
	                         new double[]{210, 210, 240, 240}, 4);
	        gc.strokePolyline(new double[]{110, 140, 110, 140},
	                          new double[]{210, 210, 240, 240}, 4);
	    }
}
