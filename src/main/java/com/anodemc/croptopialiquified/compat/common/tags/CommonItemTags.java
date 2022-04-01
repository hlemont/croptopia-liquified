package com.anodemc.croptopialiquified.compat.common.tags;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

// added by on-demand
public class CommonItemTags {
    public static final String NAMESPACE = "c";

    public static Tag.Identified<Item> create(String path) {
        return TagFactory.ITEM.create(new Identifier(NAMESPACE, path));
    }

    public static Tag.Identified<Item> create(String path, String subPath) {
        return CommonItemTags.create(path + "/" + subPath);
    }

    public static class CROPS {
        public static final String PATH = "crops";
        public static final Tag.Identified<Item> ROOT = create(PATH);

        public static final Tag.Identified<Item> BASIL = create(PATH, "basil");
        public static final Tag.Identified<Item> BLACKBEANS = create(PATH, "blackbeans");
        public static final Tag.Identified<Item> CABBAGE = create(PATH, "cabbage");
        public static final Tag.Identified<Item> CHILE_PEPPERS = create(PATH, "chile_peppers");
        public static final Tag.Identified<Item> COFFEE_BEANS = create(PATH, "coffee_beans");
        public static final Tag.Identified<Item> HOPS = create(PATH, "hops");
        public static final Tag.Identified<Item> NUTMEG = create(PATH, "nutmeg");
        public static final Tag.Identified<Item> ONION = create(PATH, "onion");
        public static final Tag.Identified<Item> PAPRIKA = create(PATH, "paprika");
        public static final Tag.Identified<Item> PEANUTS = create(PATH, "peanuts");
        public static final Tag.Identified<Item> RICE = create(PATH, "rice");
        public static final Tag.Identified<Item> TOMATO = create(PATH, "tomato");
        public static final Tag.Identified<Item> VANILLA = create(PATH, "vanilla");
    }

    public static class NUTS {
        public static final String PATH = "nuts";
        public static final Tag.Identified<Item> ROOT = create(PATH);

        
        public static final Tag.Identified<Item> ALMONDS = create(PATH, "almonds");
        public static final Tag.Identified<Item> PECANS = create(PATH, "pecans");
        public static final Tag.Identified<Item> WALNUTS = create(PATH, "walnuts");
    };

    public static class FRUITS {
        public static final String PATH = "fruits";
        public static final Tag.Identified<Item> ROOT = create(PATH);

        public static final Tag.Identified<Item> ALMONDS = create(PATH, "almonds");
        public static final Tag.Identified<Item> APRICOTS = create(PATH, "apricots");
        public static final Tag.Identified<Item> AVOCADOS = create(PATH, "avocados");
        public static final Tag.Identified<Item> BANANAS = create(PATH, "bananas");
        public static final Tag.Identified<Item> BELLPEPPERS = create(PATH, "bellpeppers");
        public static final Tag.Identified<Item> BLACKBERRIES = create(PATH, "blackberries");
        public static final Tag.Identified<Item> BLUEBERRIES = create(PATH, "blueberries");
        public static final Tag.Identified<Item> CANTALOUPES = create(PATH, "cantaloupes");
        public static final Tag.Identified<Item> CASHEWS = create(PATH, "cashews");
        public static final Tag.Identified<Item> CHERRIES = create(PATH, "cherries");
        public static final Tag.Identified<Item> COCONUTS = create(PATH, "coconuts");
        public static final Tag.Identified<Item> CRANBERRIES = create(PATH, "cranberries");
        public static final Tag.Identified<Item> CURRANTS = create(PATH, "currants");
        public static final Tag.Identified<Item> DATES = create(PATH, "dates");
        public static final Tag.Identified<Item> DRAGONFRUITS = create(PATH, "dragonfruits");
        public static final Tag.Identified<Item> ELDERBERRIES = create(PATH, "elderberries");
        public static final Tag.Identified<Item> FIGS = create(PATH, "figs");
        public static final Tag.Identified<Item> GRAPEFRUITS = create(PATH, "grapefruits");
        public static final Tag.Identified<Item> GRAPES = create(PATH, "grapes");
        public static final Tag.Identified<Item> HONEYDEW = create(PATH, "honeydew");
        public static final Tag.Identified<Item> KIWIS = create(PATH, "kiwis");
        public static final Tag.Identified<Item> KUMQUAT = create(PATH, "kumquat");
        public static final Tag.Identified<Item> LEMONS = create(PATH, "lemons");
        public static final Tag.Identified<Item> LIMES = create(PATH, "limes");
        public static final Tag.Identified<Item> MANGOS = create(PATH, "mangos");
        public static final Tag.Identified<Item> NECTARINES = create(PATH, "nectarines");
        public static final Tag.Identified<Item> OLIVES = create(PATH, "olives");
        public static final Tag.Identified<Item> ORANGES = create(PATH, "oranges");
        public static final Tag.Identified<Item> PEACHES = create(PATH, "peaches");
        public static final Tag.Identified<Item> PEARS = create(PATH, "pears");
        public static final Tag.Identified<Item> PECANS = create(PATH, "pecans");
        public static final Tag.Identified<Item> PERSIMMONS = create(PATH, "persimmons");
        public static final Tag.Identified<Item> PINEAPPLES = create(PATH, "pineapples");
        public static final Tag.Identified<Item> PLUMS = create(PATH, "plums");
        public static final Tag.Identified<Item> RASPBERRIES = create(PATH, "raspberries");
        public static final Tag.Identified<Item> STARFRUITS = create(PATH, "starfruits");
        public static final Tag.Identified<Item> STRAWBERRIES = create(PATH, "strawberries");
    }

    public static class VEGETABLES {
        public static final String PATH = "vegetables";
        public static final Tag.Identified<Item> ROOT = create(PATH);

        public static final Tag.Identified<Item> ARTICHOKES = create(PATH, "artichokes");
        public static final Tag.Identified<Item> ASPARAGUS = create(PATH, "asparagus");
        public static final Tag.Identified<Item> BROCCOLI = create(PATH, "broccoli");
        public static final Tag.Identified<Item> CABBAGE = create(PATH, "cabbage");
        public static final Tag.Identified<Item> CAULIFLOWER = create(PATH, "cauliflower");
        public static final Tag.Identified<Item> CELERY = create(PATH, "celery");
        public static final Tag.Identified<Item> CUCUMBER = create(PATH, "cucumber");
        public static final Tag.Identified<Item> EGGPLANT = create(PATH, "eggplant");
        public static final Tag.Identified<Item> GARLIC = create(PATH, "garlic");
        public static final Tag.Identified<Item> GINGER = create(PATH, "ginger");
        public static final Tag.Identified<Item> GREENBEANS = create(PATH, "greenbeans");
        public static final Tag.Identified<Item> GREENONIONS = create(PATH, "greenonions");
        public static final Tag.Identified<Item> KALE = create(PATH, "kale");
        public static final Tag.Identified<Item> LEEK = create(PATH, "leek");
        public static final Tag.Identified<Item> LETTUCE = create(PATH, "lettuce");
        public static final Tag.Identified<Item> MUSTARD = create(PATH, "mustard");
        public static final Tag.Identified<Item> ONION = create(PATH, "onion");
        public static final Tag.Identified<Item> RADISHES = create(PATH, "radishes");
        public static final Tag.Identified<Item> RHUBARB = create(PATH, "rhubarb");
        public static final Tag.Identified<Item> RUTABAGAS = create(PATH, "rutabagas");
        public static final Tag.Identified<Item> SOYBEANS = create(PATH, "soybeans");
        public static final Tag.Identified<Item> SPINACH = create(PATH, "spinach");
        public static final Tag.Identified<Item> SQUASH = create(PATH, "squash");
        public static final Tag.Identified<Item> SWEETPOTATOS = create(PATH, "sweetpotatos");
        public static final Tag.Identified<Item> TOMATILLOS = create(PATH, "tomatillos");
        public static final Tag.Identified<Item> TOMATOES = create(PATH, "tomatoes");
        public static final Tag.Identified<Item> TURNIPS = create(PATH, "turnips");
        public static final Tag.Identified<Item> YAMS = create(PATH, "yams");
        public static final Tag.Identified<Item> ZUCCHINI = create(PATH, "zucchini");
    }

    public static class GRAIN {
        public static final String PATH = "grain";
        public static final Tag.Identified<Item> ROOT = create(PATH);

        public static final Tag.Identified<Item> BARLEY = create(PATH, "barley");
        public static final Tag.Identified<Item> CORN = create(PATH, "corn");
        public static final Tag.Identified<Item> OATS = create(PATH, "oats");
        public static final Tag.Identified<Item> RICE = create(PATH, "rice");
    }

    public static final Tag.Identified<Item> SAGUAROS = create("saguaros");
    public static final Tag.Identified<Item> SALT = create("salt");
    public static final Tag.Identified<Item> SALTS = create("salts");
    public static final Tag.Identified<Item> FLOUR = create("flour");
    public static final Tag.Identified<Item> DOUGHS = create("doughs");
    public static final Tag.Identified<Item> NOODLES = create("noodles");
    public static final Tag.Identified<Item> TORTILLAS = create("tortillas");
    public static final Tag.Identified<Item> TOASTS = create("toasts");
    public static final Tag.Identified<Item> RAISINS = create("raisins");
    public static final Tag.Identified<Item> TOFU = create("tofu");
    public static final Tag.Identified<Item> CHEESES = create("cheeses");
    public static final Tag.Identified<Item> JELLIES = create("jellies");
    public static final Tag.Identified<Item> PEPPERONI = create("pepperoni");
    public static final Tag.Identified<Item> BUTTERS = create("butters");

}
