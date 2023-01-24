package com.anodemc.croptopialiquified.compat.common.tags;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

// added by on-demand
public class CommonItemTags {
    public static final String NAMESPACE = "c";

    public static TagKey<Item> create(String path) {

        return TagKey.of(Registry.ITEM_KEY, new Identifier(NAMESPACE, path));
    }

    public static TagKey<Item> create(String path, String subPath) {
        return CommonItemTags.create(path + "/" + subPath);
    }

    public static class CROPS {
        public static final String PATH = "crops";

        public static final TagKey<Item> ROOT = create(PATH);

        public static final TagKey<Item> BASIL = create(PATH, "basil");
        public static final TagKey<Item> BLACKBEANS = create(PATH, "blackbean");
        public static final TagKey<Item> CABBAGE = create(PATH, "cabbage");
        public static final TagKey<Item> CHILE_PEPPERS = create(PATH, "chile_pepper");
        public static final TagKey<Item> COFFEE_BEANS = create(PATH, "coffee_beans");
        public static final TagKey<Item> HOPS = create(PATH, "hops");
        public static final TagKey<Item> NUTMEG = create(PATH, "nutmeg");
        public static final TagKey<Item> ONION = create(PATH, "onion");
        public static final TagKey<Item> PEANUTS = create(PATH, "peanut");
        public static final TagKey<Item> RICE = create(PATH, "rice");
        public static final TagKey<Item> TOMATO = create(PATH, "tomato");
        public static final TagKey<Item> VANILLA = create(PATH, "vanilla");
        public static final TagKey<Item> CASHEWS = create(PATH, "cashew");
    }

    public static class NUTS {
        public static final String PATH = "nuts";
        public static final TagKey<Item> ROOT = create(PATH);


        public static final TagKey<Item> ALMONDS = create(PATH, "almond");
        public static final TagKey<Item> PECANS = create(PATH, "pecan");
        public static final TagKey<Item> WALNUTS = create(PATH, "walnut");
    }


    public static class FRUITS {
        public static final String PATH = "fruits";
        public static final TagKey<Item> ROOT = create(PATH);

        public static final TagKey<Item> ALMONDS = create(PATH, "almond");
        public static final TagKey<Item> APRICOTS = create(PATH, "apricot");
        public static final TagKey<Item> AVOCADOS = create(PATH, "avocado");
        public static final TagKey<Item> BANANAS = create(PATH, "banana");
        public static final TagKey<Item> BELLPEPPERS = create(PATH, "bellpepper");
        public static final TagKey<Item> BLACKBERRIES = create(PATH, "blackberry");
        public static final TagKey<Item> BLUEBERRIES = create(PATH, "blueberry");
        public static final TagKey<Item> CANTALOUPES = create(PATH, "cantaloupe");
        public static final TagKey<Item> CHERRIES = create(PATH, "cherry");
        public static final TagKey<Item> COCONUTS = create(PATH, "coconut");
        public static final TagKey<Item> CRANBERRIES = create(PATH, "cranberry");
        public static final TagKey<Item> CURRANTS = create(PATH, "currant");
        public static final TagKey<Item> DATES = create(PATH, "date");
        public static final TagKey<Item> DRAGONFRUITS = create(PATH, "dragonfruit");
        public static final TagKey<Item> ELDERBERRIES = create(PATH, "elderberry");
        public static final TagKey<Item> FIGS = create(PATH, "fig");
        public static final TagKey<Item> GRAPEFRUITS = create(PATH, "grapefruit");
        public static final TagKey<Item> GRAPES = create(PATH, "grape");
        public static final TagKey<Item> HONEYDEW = create(PATH, "honeydew");
        public static final TagKey<Item> KIWIS = create(PATH, "kiwi");
        public static final TagKey<Item> KUMQUAT = create(PATH, "kumquat");
        public static final TagKey<Item> LEMONS = create(PATH, "lemon");
        public static final TagKey<Item> LIMES = create(PATH, "lime");
        public static final TagKey<Item> MANGOS = create(PATH, "mango");
        public static final TagKey<Item> NECTARINES = create(PATH, "nectarine");
        public static final TagKey<Item> OLIVES = create(PATH, "olive");
        public static final TagKey<Item> ORANGES = create(PATH, "orange");
        public static final TagKey<Item> PEACHES = create(PATH, "peach");
        public static final TagKey<Item> PEARS = create(PATH, "pear");
        public static final TagKey<Item> PECANS = create(PATH, "pecan");
        public static final TagKey<Item> PERSIMMONS = create(PATH, "persimmon");
        public static final TagKey<Item> PINEAPPLES = create(PATH, "pineapple");
        public static final TagKey<Item> PLUMS = create(PATH, "plum");
        public static final TagKey<Item> RASPBERRIES = create(PATH, "raspberry");
        public static final TagKey<Item> STARFRUITS = create(PATH, "starfruit");
        public static final TagKey<Item> STRAWBERRIES = create(PATH, "strawberry");
        public static final TagKey<Item> SAGUAROS = create("saguaro");
    }

    public static class VEGETABLES {
        public static final String PATH = "vegetables";
        public static final TagKey<Item> ROOT = create(PATH);

        public static final TagKey<Item> ARTICHOKES = create(PATH, "artichoke");
        public static final TagKey<Item> ASPARAGUS = create(PATH, "asparagus");
        public static final TagKey<Item> BROCCOLI = create(PATH, "broccoli");
        public static final TagKey<Item> CABBAGE = create(PATH, "cabbage");
        public static final TagKey<Item> CAULIFLOWER = create(PATH, "cauliflower");
        public static final TagKey<Item> CELERY = create(PATH, "celery");
        public static final TagKey<Item> CUCUMBER = create(PATH, "cucumber");
        public static final TagKey<Item> EGGPLANT = create(PATH, "eggplant");
        public static final TagKey<Item> GARLIC = create(PATH, "garlic");
        public static final TagKey<Item> GINGER = create(PATH, "ginger");
        public static final TagKey<Item> GREENBEANS = create(PATH, "greenbean");
        public static final TagKey<Item> GREENONIONS = create(PATH, "greenonion");
        public static final TagKey<Item> KALE = create(PATH, "kale");
        public static final TagKey<Item> LEEK = create(PATH, "leek");
        public static final TagKey<Item> LETTUCE = create(PATH, "lettuce");
        public static final TagKey<Item> MUSTARD = create(PATH, "mustard");
        public static final TagKey<Item> ONION = create(PATH, "onion");
        public static final TagKey<Item> RADISHES = create(PATH, "radish");
        public static final TagKey<Item> RHUBARB = create(PATH, "rhubarb");
        public static final TagKey<Item> RUTABAGAS = create(PATH, "rutabaga");
        public static final TagKey<Item> SOYBEANS = create(PATH, "soybean");
        public static final TagKey<Item> SPINACH = create(PATH, "spinach");
        public static final TagKey<Item> SQUASH = create(PATH, "squash");
        public static final TagKey<Item> SWEETPOTATOS = create(PATH, "sweetpotato");
        public static final TagKey<Item> TOMATILLOS = create(PATH, "tomatillo");
        public static final TagKey<Item> TOMATOES = create(PATH, "tomato");
        public static final TagKey<Item> TURNIPS = create(PATH, "turnip");
        public static final TagKey<Item> YAMS = create(PATH, "yam");
        public static final TagKey<Item> ZUCCHINI = create(PATH, "zucchini");
    }

    public static class GRAIN {
        public static final String PATH = "grain";
        public static final TagKey<Item> ROOT = create(PATH);

        public static final TagKey<Item> BARLEY = create(PATH, "barley");
        public static final TagKey<Item> CORN = create(PATH, "corn");
        public static final TagKey<Item> OATS = create(PATH, "oats");
        public static final TagKey<Item> RICE = create(PATH, "rice");
    }

    public static final TagKey<Item> SALT = create("salt");
    public static final TagKey<Item> SALTS = create("salt");
    public static final TagKey<Item> FLOUR = create("flour");
    public static final TagKey<Item> DOUGHS = create("doughs");
    public static final TagKey<Item> NOODLES = create("noodles");
    public static final TagKey<Item> TORTILLAS = create("tortillas");
    public static final TagKey<Item> TOASTS = create("toasts");
    public static final TagKey<Item> RAISINS = create("raisins");
    public static final TagKey<Item> TOFU = create("tofu");
    public static final TagKey<Item> CHEESES = create("cheeses");
    public static final TagKey<Item> JELLIES = create("jellies");
    public static final TagKey<Item> PEPPERONI = create("pepperoni");
    public static final TagKey<Item> BUTTERS = create("butters");
    public static final TagKey<Item> PAPRIKA = create("paprika");

}
