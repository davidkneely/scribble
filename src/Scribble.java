

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

/*
  This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
  Copyright (c) 1997 by David Flanagan
  This example is provided WITHOUT ANY WARRANTY either expressed or implied.
  You may study, use, modify, and distribute it for non-commercial purposes.
  For any commercial use, see http://www.davidflanagan.com/javaexamples
  A simple applet that uses the Java 1.0 event handling model.
 */

/**
 * A simple applet that uses the Java 1.0 event handling model.
 */
public class Scribble extends Applet {
  private int lastX;
  private int lastY;
  private Button clearButton;
  private Graphics graphics;

  /**
   * Initialize the button and the Graphics object.
   * */
  public void init() {
    clearButton = new Button("Clear");
    this.add(clearButton);
    graphics = this.getGraphics();
  }

  /**
   * Responds to mouse clicks.
   * @param e Input Event.
   * @param x Input x coordinate.
   * @param y Input y coordinate.
   * @return True always.
   */
  public boolean mouseDown(Event e, int x, int y) {
    lastX = x; lastY = y;
    return true;
  }
  /** */
  /**
   * Responds to mouse drags.
   * @param e Input Event.
   * @param x The x coordinate.
   * @param y The y coordinate.
   * @return True always.
   */
  public boolean mouseDrag(Event e, int x, int y) {
    graphics.setColor(Color.black);
    graphics.drawLine(lastX, lastY, x, y);
    lastX = x; lastY = y;
    return true;
  }

  /**
   * Responds to key presses.
   * @param e Input Event.
   * @param key Input key.
   * @return True if key is c.
   */
  @Override
  public boolean keyDown(Event e, int key) {
    if ((e.id == Event.KEY_PRESS) && (key == 'c')) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Responds to Button clicks.
   * @param e The input Event.
   * @param arg The input arguments. Not used.
   * @return True if event target is clearButton.
   */
  public boolean action(Event e, Object arg) {
    if (e.target == clearButton) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Convenience method to erase the scribble.
   */
  public void clear() {
    graphics.setColor(this.getBackground());
    graphics.fillRect(0, 0, bounds().width, bounds().height);
  }
}