package tran.compbuildbackend.domain.utility;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import tran.compbuildbackend.domain.computerbuild.ComputerPart;
import tran.compbuildbackend.exceptions.request.GenericRequestException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;

import static tran.compbuildbackend.constants.exception.ExceptionConstants.CANNOT_PARSE_PRICE;
import static tran.compbuildbackend.constants.tests.TestUtility.COMPUTER_BUILD_ID_KEY;
import static tran.compbuildbackend.constants.tests.TestUtility.PURCHASE_DATE_KEY;

public class ComputerPartUtility {
    public static String getComputerPartAsJson(String name, String date, String placePurchasedAt, String otherNotes,
                                               double price) {
        ComputerPart computerPart = setComputerPartFields(name, placePurchasedAt, otherNotes, price);

        String contents = new Gson().toJson(computerPart);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(contents).getAsJsonObject();
        jsonObject.addProperty(PURCHASE_DATE_KEY, date);
        return jsonObject.toString();
    }

    public static String getComputerPartAsJson(String name, String date, String placePurchasedAt, String otherNotes,
                                               double price, String computerBuildIdentifier, Long id,
                                               String computerPartUniqueIdentifier) {
        ComputerPart computerPart = setComputerPartFields(name, placePurchasedAt, otherNotes, price);
        computerPart.setId(id);
        computerPart.setUniqueIdentifier(computerPartUniqueIdentifier);

        String contents = new Gson().toJson(computerPart);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(contents).getAsJsonObject();
        jsonObject.addProperty(PURCHASE_DATE_KEY, date);
        jsonObject.addProperty(COMPUTER_BUILD_ID_KEY, computerBuildIdentifier);
        return jsonObject.toString();
    }

    private static ComputerPart setComputerPartFields(String name, String placePurchasedAt, String otherNotes, double price) {
        ComputerPart computerPart = new ComputerPart();
        computerPart.setName(name);
        computerPart.setPlacePurchasedAt(placePurchasedAt);
        computerPart.setPrice(price);
        computerPart.setOtherNote(otherNotes);
        return computerPart;
    }

    public static ComputerPart createComputerPart(String name, LocalDate localDate, String placePurchaesdAt, double price,
                                                  String otherNotes) {
        ComputerPart computerPart = new ComputerPart();
        computerPart.setName(name);
        computerPart.setPurchaseDate(localDate);
        computerPart.setPlacePurchasedAt(placePurchaesdAt);
        computerPart.setPrice(price);
        computerPart.setOtherNote(otherNotes);
        return computerPart;
    }

    public static double addValues(double totalPrice, double addingPrice)  {
        return performAdditionOrSubtraction(totalPrice, addingPrice, 1);
    }

    public static double subtractValues(double totalPrice, double subtractingPrice) {
        return performAdditionOrSubtraction(totalPrice, subtractingPrice, 2);
    }

    private static double performAdditionOrSubtraction(double totalPrice, double otherPrice, int operationType) {
        /*
         * for now it is expected computer builds won't go past 6 digits because a build is assumed to be some thousands
         * of dollars such as $3000.50 or so.
         */
        MathContext mathContext = new MathContext(10);
        BigDecimal bdTotalPrice = new BigDecimal(totalPrice, mathContext);
        BigDecimal bdOtherPrice = new BigDecimal(otherPrice, mathContext);
        BigDecimal result = null;
        if(operationType == 1) {
            result = bdTotalPrice.add(bdOtherPrice);
        } else if(operationType == 2) {
            result = bdTotalPrice.subtract(bdOtherPrice);
        }
        String resultAsStr = NumberFormat.getCurrencyInstance().format(result);
        try {
            return NumberFormat.getCurrencyInstance().parse(resultAsStr).doubleValue();
        } catch(ParseException ex) {
            throw new GenericRequestException(CANNOT_PARSE_PRICE);
        }
    }
}
