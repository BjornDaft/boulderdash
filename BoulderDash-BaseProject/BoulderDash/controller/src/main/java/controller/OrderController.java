package controller;

import model.IModelFacade;
import model.IPosition;
import model.IMove;
import model.IPlayer;
import view.IViewFacade;

import java.io.IOException;

/**
 * The Class OrderController provides movements for the view and the character.
 */
public class OrderController extends java.util.Observable {
    private IModelFacade model;
    private IViewFacade view;
    private IPosition position;
    private IPlayer character;
    private int scoreContr;
    private ControllerFacade controllerFacade;

    /**
     * Instantiates a new Order controller.
     *
     * @param build the build
     */
    public OrderController() {
    }


    /**
     * Perform order.
     *
     * @param userOrder the user order
     * @param model     the model
     * @param view      the view
     * @throws IOException the io exception
     */
    public void performOrder(IUserOrder userOrder, IModelFacade model, IViewFacade view) throws IOException {
        

        this.view = view;
        this.model = model;

       /* switch (userOrder.getOrder()) {
            case UP:
                character.moveUp(movable, position);
                if (character.getDiamond()) {
                    this.scoreContr++;
                    view.setScore(scoreContr);
                }
                break;

            case DOWN:
                character.moveDown(movable, position);
                if (character.getDiamond()) {
                    this.scoreContr++;
                    view.setScore(scoreContr);
                }
                break;

            case LEFT:
                character.moveLeft(movable, position);
                collision = character.getColli();
                if (character.getDiamond()) {
                    this.scoreContr++;
                    view.setScore(scoreContr);
                }
                break;

            case RIGHT:
                character.moveRight(movable, position);
                collision = character.getColli();
                if (character.getDiamond()) {
                    this.scoreContr++;
                    view.setScore(scoreContr);
                }
                break;
        }
        character.refreshAround(position);
        build.setPos(x, y);
        setChanged();
        notifyObservers();*/
    }
}