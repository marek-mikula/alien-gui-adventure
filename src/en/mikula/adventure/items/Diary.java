package en.mikula.adventure.items;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.text.AsciArt;
import en.mikula.adventure.text.GameText;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Diary extends Item implements Interactive {

    public static final String STORAGE_CODE = "1948";

    private final Game game;

    public Diary(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "Ellen Ripley's diary";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_0;
    }

    @Override
    public String interact() {
        if (game.getMode().equals(Game.MODE_TEXT)) {
            return String.format(AsciArt.diaryArt(), STORAGE_CODE);
        }

        return String.format(GameText.diary(), STORAGE_CODE);
    }
}
