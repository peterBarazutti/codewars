package six_kyu;

import java.util.*;
import java.util.stream.Collectors;

public class Travel {

    public static String travel(String r, String zipcode){


        class Location {
            int houseNumber;
            String address;
            String zipCode;

            public Location(int houseNumber, String address, String zipCode) {
                this.houseNumber = houseNumber;
                this.address = address;
                this.zipCode = zipCode;
            }
        }

        Set<Location> storedAddresses = new LinkedHashSet<>();
        String[] addresses = r.split(",");
        for (String address:addresses) {
            String[] temp = address.split(" ");
            int tempNum = Integer.parseInt(temp[0]);
            String tempZip = temp[temp.length-2] + " " + temp[temp.length-1];
            String tempAddress = String.join(" ",
                    Arrays.copyOfRange(temp, 1, temp.length-2));
            storedAddresses.add(new Location(tempNum, tempAddress, tempZip));
        }
        List<Location> locationList = storedAddresses.stream().filter(address -> address.zipCode.equals(zipcode)).collect(Collectors.toList());
        String resultString = zipcode.concat(":");
        List<String> tempAddressList = new ArrayList<>();
        List<String> tempHouseNumberList = new ArrayList<>();
        for (Location loc:locationList) {
            tempAddressList.add(loc.address);
            tempHouseNumberList.add(String.valueOf(loc.houseNumber));
        }
/*        Collections.reverse(tempAddressList);
        Collections.reverse(tempHouseNumberList);*/
        String addressString = resultString.join(",", tempAddressList);
        String houseNumberString = resultString.join(",", tempHouseNumberList);
        return resultString
                .concat(addressString)
                .concat("/")
                .concat(houseNumberString);
    }
}
