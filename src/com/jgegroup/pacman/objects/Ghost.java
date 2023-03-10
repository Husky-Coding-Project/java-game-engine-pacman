package com.jgegroup.pacman.objects;

import com.jgegroup.pacman.objects.immovable.Wall;
import javafx.scene.paint.Color;
import com.jgegroup.pacman.objects.Enums.*;


// Note: Death and respawning will be handled by the game cycle by the reassignment of the ghost to
// another ghost.

public class Ghost extends MovingObject {
    // Spook length is the cycle length interval for how long a ghost will
    // be spooked. Can exceed this length if more big dots are eaten
    private final int spookLength;
    // Container for base color of the Ghost which is the color that the Ghost is when not spooked
    private Color base_color;
    // Container for the color of the Ghost that we're currently showing to the screen
    private Color current_color;
    // State container for the spook timer
    private int spookState;


    public Ghost(int x, int y, int spookLength, Color color) {
        super(x, y);
        this.spookLength = spookLength;
        this.base_color = color;
        this.current_color = color;
        // this indicates that it is not spooked, -1 <- no spook. > 0 <- yes spook
        this.spookState = -1;
        this.direction = Direction.STOP;
    }

    // Authors: Noah / Nicola
    // Sets spookState to maximum spook state 'spookLength'
    // spook length represents the number of cycles to be spooked
    // Throws no exceptions
    // Returns nothing
    // Takes no parameters
    public void setSpooked() { spookState += spookLength; }

    // Authors: Noah / Nicola
    // Updatess the spook state, if the state is even it will change the color of the ghost
    // to white, and if its odd then it will change to blue, if not spooked it will return to original color
    // Throws no exceptions
    // Returns true if is currently spooked or if its coming out of being spooked
    // Takes no parameters
    public boolean updateSpooked() {
        if (spookState >= 0) {
            if (spookState % 2 == 0) {
                this.current_color = Color.WHITE;
            } else {
                this.current_color = Color.BLUE;
            }
            spookState--;
            if (spookState < 0) {
                this.current_color = base_color;
            }
            return true;
        }
        return false;
    }

    // Author: Noah
    // Checks to see if the ghost is spooked
    // Throws no exceptions
    // Returns true if spookState container is greater than or equal to 0, else false
    // Takes in no paramters
    public boolean isSpooked() { return spookState >= 0; }


    public void think(){

    }

    // Authors: Jesse / Noah
    // Determines if the object has collided with something or not
    // Throws, no exceptions
    // Returns 1 if collided with Pacman or Wall, 0 otherwise
    // Takes in a GameObject as a parameter
    @Override
    protected int collisionHandle(MovingObject object) {
//        if (object instanceof Pacman) {
//            return 1;
//        } else if (object instanceof Wall) {
//            return 2;
//        }
        return 0;
    }
}
