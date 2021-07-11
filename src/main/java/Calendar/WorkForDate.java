package Calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
public class WorkForDate {



        Date date = new Date();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Date> dateList = new ArrayList<>(15);

        public void parse(String datePart, Date date) {
            if (datePart.contains("/")) {
                String[] dateParts = datePart.split("/");
                for (int i = 0; i < dateParts.length; i++) {
                    if (dateParts[i].isEmpty())
                        dateParts[i] = "1";
                }
                date.setDay(Integer.parseInt(dateParts[0]));
                date.setMonth(Integer.parseInt(dateParts[1]));
                if (dateParts.length < 3) {
                    date.setYear(2021);
                } else {
                    date.setYear(Integer.parseInt(dateParts[2]));
                }
            } else {
                date.setYear(Integer.parseInt(datePart));
            }
        }

        public void createDate() {
            try {

                String dateRead = reader.readLine();
                int emptyIndex = dateRead.indexOf(" ");

                if (emptyIndex >= 3) {
                    String datePart = dateRead.substring(0, emptyIndex);
                    parse(datePart, date);
                    String duration = dateRead.substring(dateRead.indexOf(" ")+1);
                    String[] timeParts = duration.split(":");
                    if (timeParts.length < 3) {
                        date.setMinute(Integer.parseInt(timeParts[0]));
                        date.setSecond(Integer.parseInt(timeParts[1]));
                    } else {
                        date.setHour(Integer.parseInt(timeParts[0]));
                        date.setMinute(Integer.parseInt(timeParts[1]));
                        date.setSecond(Integer.parseInt(timeParts[2]));
                    }

                } else {
                    parse(dateRead, date);
                }
                dateList.add(date);
            } catch (IOException | ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println("Sorry, please enter correct data");
                createDate();
            }
        }

        public void add() {
            System.out.println("Enter: Format: 1/10/34 or /5/47 or /2/ or 1256 59:59");
            createDate();

            System.out.println("""
                    Enter action to add to date:\s
                    1 - sec
                    2 - min
                    3 - hour
                    4 - days
                    5 - month
                    6 - year
                    0 - Exit to the main menu.""");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String read;
                while ((read = reader.readLine()) != null) {
                    switch (read) {
                        case "1" -> {
                            System.out.println("Enter seconds to add: ");
                            int second = Integer.parseInt(reader.readLine());
                            addSecond(dateList, second);
                            System.out.println(dateList.get(0));
                        }
                        case "2" -> {
                            System.out.println("Enter minutes to add: ");
                            int minute = Integer.parseInt(reader.readLine());
                            addMinute(dateList, minute);
                            System.out.println(dateList.get(0));
                        }
                        case "3" -> {
                            System.out.println("Enter hours to add: ");
                            int hour = Integer.parseInt(reader.readLine());
                            addHour(dateList, hour);
                            System.out.println(dateList.get(0));
                        }
                        case "4" -> {
                            System.out.println("Enter days to add: ");
                            int day = Integer.parseInt(reader.readLine());
                            addDay(dateList, day);
                            System.out.println(dateList.get(0));
                        }
                        case "5" -> {
                            System.out.println("Enter month to add: ");
                            int month = Integer.parseInt(reader.readLine());
                            addMonth(dateList, month);
                            System.out.println(dateList.get(0));
                        }
                        case "6" -> {
                            System.out.println("Enter Years to add: ");
                            int year = Integer.parseInt(reader.readLine());
                            addYear(dateList, year);
                            System.out.println(dateList.get(0));
                        }
                        case "0" -> {
                            dateList.clear();
                            System.exit(0);
                        }
                    }
                }
            } catch (IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        public void minus() {
            System.out.println("Enter: Format: 1/10/34 or /5/47 or /2/ or 1256 59:59");
            createDate();

            System.out.println("""
                    Enter the action to subtract the date:\s
                    1 - sec
                    2 - min
                    3 - hour
                    4 - days
                    5 - month
                    6 - year
                    0 - Exit to the main menu.""");
            try {
                String read;
                while ((read = reader.readLine()) != null) {

                    switch (read) {
                        case "1" -> {
                            System.out.println("Enter seconds for minus date:");
                            int seconds = Integer.parseInt(reader.readLine());
                            minusSeconds(dateList, seconds);
                            System.out.println(dateList.get(0));
                        }
                        case "2" -> {
                            System.out.println("Enter minutes for minus date: ");
                            int minutes = Integer.parseInt(reader.readLine());
                            minusMinutes(dateList, minutes);
                            System.out.println(dateList.get(0));
                        }
                        case "3" -> {
                            System.out.println("Enter hours for minus date: ");
                            int hours = Integer.parseInt(reader.readLine());
                            minusHours(dateList, hours);
                            System.out.println(dateList.get(0));
                        }
                        case "4" -> {
                            System.out.println("Enter days for minus date: ");
                            int days = Integer.parseInt(reader.readLine());
                            minusDays(dateList, days);
                            System.out.println(dateList.get(0));
                        }
                        case "5" -> {
                            System.out.println("Enter month for minus date: ");
                            int month = Integer.parseInt(reader.readLine());
                            minusMonth(dateList, month);
                            System.out.println(dateList.get(0));
                        }
                        case "6" -> {
                            System.out.println("Enter years for minus date:");
                            int years = Integer.parseInt(reader.readLine());
                            minusYear(dateList, years);
                            System.out.println(dateList.get(0));
                        }
                        case "0" -> {
                            dateList.clear();
                            System.exit(0);
                        }
                    }
                }
            }
            catch (IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        public void difference() {

            int iter = 1;

            while (iter <= 2) {

                System.out.println("Enter date: Format: 1/10/34 or /5/47 or /2/ or 1256 59:59");
                System.out.println("Enter " + iter + " Calendar.Date: ");
                createDate();
                iter++;

            }

            for (Date date1 : dateList) {
                System.out.println(date1);
            }
            System.out.println("""
                    Enter an action to find the date difference in:\s
                    1 - sec
                    2 - min
                    3 - hours
                    4 - days
                    5 - month
                    6 - year
                    0 - Exit to the main menu.""");

            try {
                String read;
                while ((read = reader.readLine()) != null) {

                    switch (read) {
                        case "1" -> System.out.println("difference in sec:  " + differenceInSeconds());
                        case "2" -> System.out.println("difference in min: " + differenceInMinutes());
                        case "3" -> System.out.println("difference in hour: " + differenceInHours());
                        case "4" -> System.out.println("difference in days: " + differenceInDay());
                        case "5" -> System.out.println("difference in Month: " + differenceInMonth());
                        case "6" -> System.out.println("difference in Year: " + differenceInYear());
                        case "0" -> dateList.clear();
                    }
                }
            }
            catch (IOException | IllegalArgumentException e) {
                System.out.println(e);
            }
        }

        public void compare() throws IOException {
            int i = 1;

            String read;
            while ((read = reader.readLine()) != null) {
                System.out.println("""
                    1 -> set date
                    2 -> sort""");
                switch (read) {
                    case "1": {
                        System.out.println("Enter " + i + " Calendar.Date: ");
                        System.out.println("Enter the date: format: 1/10/34 or /5/47 or /2/ or 1256 59:59");
                        createDate();
                        i++;
                    }
                    case "2": {
                    }
                    default: {
                        System.out.println("Извините, вы ввели неправильные данные. ");
                    }
                }

                String s;
                while ((s = reader.readLine()) != null) {
                    System.out.println("1 - Display ascending" + "2 - Display descending ");
                    System.out.println("""
                        Select function:\040
                        1 -Display date in ascending order.
                        2 - Display the date in descending order.
                        0 - Exit to the main menu""");

                    switch (s) {
                        case "1" -> {
                            System.out.println("Дата до: ");
                            dateList.forEach(System.out::println);
                            System.out.println("Дата после: ");
                            dateList.sort(Date::compareTo);
                            dateList.forEach(System.out::println);
                        }
                        case "2" -> {
                            System.out.println("Дата до: ");
                            dateList.forEach(System.out::println);
                            System.out.println("Дата после: ");
                            dateList.sort(Comparator.reverseOrder());
                            dateList.forEach(System.out::println);
                        }
                        case "0" -> dateList.clear();
                        default -> System.out.println("incorrect data.");
                    }
                }
            }
        }

        public void addYear(ArrayList<Date> dateList, int year) {
            if (year > 0) {
                dateList.get(0).setYear(dateList.get(0).getYear() + year);
            } else {
                System.out.println("incorrect data.");
            }
        }

        public void addDay(ArrayList<Date> dateList, int day) {
            if (day > 0) {
                int index = date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear());
                if (index < day) {
                    day -= index - dateList.get(0).getDay() + 1;
                    dateList.get(0).setDay(1);
                    try {
                        dateList.get(0).setMonth(dateList.get(0).getMonth() + 1);
                    } catch (IllegalArgumentException e) {
                        dateList.get(0).setMonth(1);
                        dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                    }
                    while (day >= 365) {
                        if (dateList.get(0).getYear() % 4 == 0 && day > 365) {
                            dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                            day -= 366;
                        } else if (dateList.get(0).getYear() % 4 != 0) {
                            dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                            day -= 365;
                        }
                    }
                    while (day >= 28) {
                        index = date.getDaysInMonth(dateList.get(0).getMonth(),
                                dateList.get(0).getYear());
                        if (index <= day) {
                            try {
                                dateList.get(0).setMonth(dateList.get(0).getMonth() + 1);
                            } catch (IllegalArgumentException e) {
                                dateList.get(0).setMonth(1);
                                dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                            }
                            day -= index;
                        } else
                            break;
                    }
                }
                index = date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear());
                for (int i = dateList.get(0).getDay(); i <= (index + 1); i++) {
                    if (day != 0) {
                        try {
                            dateList.get(0).setDay(dateList.get(0).getDay() + 1);
                        } catch (IllegalArgumentException argDays) {
                            dateList.get(0).setDay(1);
                            try {
                                dateList.get(0).setMonth(dateList.get(0).getMonth() + 1);
                            } catch (IllegalArgumentException argMonth) {
                                dateList.get(0).setMonth(1);
                                dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                            }
                        }
                        day--;
                    }
                }
                if (day != 0)
                    dateList.get(0).setDay(dateList.get(0).getDay() + day);
            } else {
                System.out.println("incorrect data.");
            }
        }

        public void addHour(ArrayList<Date> dateList, int hour) {
            if (hour > 0) {
                if (hour >= 24) {
                    addDay(dateList, hour / 24);
                    dateList.get(0).setHour(hour % 24);
                } else {
                    dateList.get(0).setHour(dateList.get(0).getHour() + hour % 24);
                    if (dateList.get(0).getHour() >= 24) {
                        dateList.get(0).setHour(dateList.get(0).getHour() - 24);
                        try {
                            dateList.get(0).setDay(dateList.get(0).getDay() + 1);
                        } catch (IllegalArgumentException argDays) {
                            if (dateList.get(0).getHour() == 24)
                                dateList.get(0).setHour(0);
                            if (dateList.get(0).getDay() > date.getDaysInMonth(dateList.get(0).getMonth(),
                                    dateList.get(0).getYear())) {
                                dateList.get(0).setDay(1);
                                try {
                                    dateList.get(0).setMonth(dateList.get(0).getMonth() + 1);
                                } catch (IllegalArgumentException e) {
                                    dateList.get(0).setMonth(1);
                                    dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("incorrect data.");
            }
        }

        public void addMinute(ArrayList<Date> dateList, int minute) {
            if (minute > 0) {
                int newMinutes = dateList.get(0).getMinute() + minute;
                if (newMinutes > 59) {
                    dateList.get(0).setMinute(newMinutes % 60);
                    addHour(dateList, newMinutes / 60);
                } else {
                    dateList.get(0).setMinute(newMinutes);
                }
            } else {
                System.out.println("incorrect data.");
            }
        }

        public void addMonth(ArrayList<Date> dateList, int month) throws IOException {
            if (month > 0) {
                if (month / 12 > 0) {
                    dateList.get(0).setYear(dateList.get(0).getYear() + (month / 12));
                    if (month % 12 + dateList.get(0).getMonth() <= 12) {
                        dateList.get(0).setMonth(dateList.get(0).getMonth() + month % 12);
                    }
                } else {
                    dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                    dateList.get(0).setMonth(month - (12 - dateList.get(0).getMonth()));
                }
            } else {
                System.out.println("incorrect data.");
            }
        }

        public void addSecond(ArrayList<Date> dateList, int second) throws IOException {
            if (second >= 0) {
                int newSecond = dateList.get(0).getSecond() + second;
                if (newSecond > 59) {
                    dateList.get(0).setMinute(newSecond % 60);
                    addMinute(dateList, newSecond / 60);
                } else {
                    dateList.get(0).setMinute(newSecond);
                }
                date.setSecond(newSecond);
            } else {
                System.out.println("incorrect data.");
            }
        }

        public int differenceInMonth(){
            return (Math.abs(dateList.get(0).getMonth() - dateList.get(1).getMonth()) +
                    (Math.abs(dateList.get(0).getYear() - dateList.get(1).getYear())* 12));
        }

        public int differenceInSeconds(){
            return (Math.abs(dateList.get(0).getSecond() - dateList.get(1).getSecond()) + differenceInMinutes() * 60);
        }

        public int differenceInMinutes(){
            return (Math.abs(dateList.get(0).getMinute() - dateList.get(1).getMinute()) + differenceInHours() * 60);
        }

        public int differenceInHours(){
            return (Math.abs(dateList.get(0).getHour() - dateList.get(1).getHour()) + differenceInDay() * 24);
        }

        public int differenceInDay(){
            return (Math.abs(dateList.get(0).getDay() - dateList.get(1).getDay()) + forDifferenceInDay());
        }

        public int differenceInYear(){
            return Math.abs(dateList.get(0).getYear() - dateList.get(1).getYear());
        }

        public int forDifferenceInDay() {
            int[] ALL_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int days = 0;

            int monthForDiff1 = dateList.get(0).getMonth();
            int monthForDiff2 = dateList.get(1).getMonth();
            int count = Math.abs(monthForDiff1 - monthForDiff2);

            int index = Math.min(dateList.get(0).getMonth(),dateList.get(1).getMonth());
            int firstYear = dateList.get(0).getYear();
            int differYear = differenceInYear();

            while (differYear > 0) {
                if (++firstYear % 4 == 0) {
                    days += 366;
                } else {
                    days += 365;
                }
                differYear--;
            }
            for (int i = 0; i < count; i++) {
                days += ALL_DAYS[index];
                index++;
            }
            return days;
        }

        private void minusYear(ArrayList<Date> dateList, int years) {
            if (years > 0) {
                dateList.get(0).setYear(dateList.get(0).getYear() - years);
            } else
                System.out.println("Sorry, you entered incorrect data.");
        }

        private void minusMonth(ArrayList<Date> dateList, int month) {
            if (month > 0) {
                if (month / 12 > 0) {
                    dateList.get(0).setYear(dateList.get(0).getYear() - (month / 12));
                    if (month % 12 > dateList.get(0).getMonth()) {
                        month = dateList.get(0).getMonth();
                        dateList.get(0).setMonth( 12 - month);
                        dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                    }
                    else {
                        dateList.get(0).setMonth(dateList.get(0).getMonth() - month % 12);
                        if(dateList.get(0).getMonth() == 0) {
                            dateList.get(0).setMonth(12);
                            dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                        }
                    }
                }
            } else {
                System.out.println("Sorry, you entered incorrect data.");
            }
        }

        private void minusDays(ArrayList<Date> dateList, int days) {
            if (days > 0) {
                int index;
                if(dateList.get(0).getDay() <= days ) {
                    days -= dateList.get(0).getDay();
                    try {
                        dateList.get(0).setMonth(dateList.get(0).getMonth() - 1);
                    } catch (IllegalArgumentException e) {
                        dateList.get(0).setMonth(12);
                        dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                    }
                    dateList.get(0).setDay(date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear()));
                }
                else {
                    dateList.get(0).setDay(dateList.get(0).getDay() - days);
                    return;
                }

                while (days >= 365) {
                    if (dateList.get(0).getYear() % 4 == 0 && days > 365) {
                        dateList.get(0).setYear(dateList.get(0).getYear()-1);
                        days -= 366;
                    } else if (dateList.get(0).getYear() % 4 != 0) {
                        dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                        days -= 365;
                    }
                }
                while (days >= 28) {
                    index = date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear());
                    if (index <= days) {
                        try {
                            dateList.get(0).setMonth(dateList.get(0).getMonth()-1);
                        }
                        catch (IllegalArgumentException e) {
                            dateList.get(0).setMonth(12);
                            dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                        }
                        days -= index;
                    } else {
                        break;
                    }
                }
                index = date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear());
                dateList.get(0).setDay(index - days);
            }
            else {
                System.out.println("Sorry, you entered incorrect data.");
            }
        }

        private void minusHours(ArrayList<Date> dateList, int hours) {
            if (hours > 0) {
                if (hours >= dateList.get(0).getHour()) {
                    hours = hours - dateList.get(0).getHour();
                    dateList.get(0).setHour(0);
                } else {
                    dateList.get(0).setHour(dateList.get(0).getHour() - hours);
                }
                if (0 < hours / 24) {
                    minusDays(dateList, hours / 24);
                    try {
                        dateList.get(0).setHour(24 - hours % 24);
                    } catch (IllegalArgumentException hour) {
                        dateList.get(0).setHour(0);
                    }
                } else {
                    try {
                        dateList.get(0).setHour(24 - hours);
                    } catch (IllegalArgumentException hour) {
                        dateList.get(0).setHour(0);
                    }
                }
                setDay(dateList);
            }
            else {
                System.out.println("Sorry, you entered incorrect data.");
            }
        }

        private void setDay(ArrayList<Date> dateList) {
            try {
                dateList.get(0).setDay(dateList.get(0).getDay() - 1);
            } catch (IllegalArgumentException days) {
                try {
                    dateList.get(0).setMonth(dateList.get(0).getMonth() - 1);
                } catch (IllegalArgumentException months) {
                    dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                    dateList.get(0).setMonth(12);
                }
                dateList.get(0).setDay(date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear()));
            }
        }

        private void minusMinutes(ArrayList<Date> dateList, int minutes) {
            if(minutes > 0) {
                int tempMinutes = dateList.get(0).getMinute();
                int newMinutes = tempMinutes - minutes;
                if(newMinutes <= 0)
                {
                    try {
                        dateList.get(0).setMinute(60 + (newMinutes % 60));
                    } catch (IllegalArgumentException min) {
                        dateList.get(0).setMinute(0);
                    }
                    if ((tempMinutes+minutes) % 60 == 0) {
                        minusHours(dateList, 1);
                    }
                    else {
                        minusHours(dateList, (tempMinutes + minutes + 60) / 60);
                        if (dateList.get(0).getHour() == 24) {
                            dateList.get(0).setHour(0);
                        }
                    }
                } else {
                    dateList.get(0).setMinute(newMinutes);
                }
            }
            else {
                System.out.println("Sorry, you entered incorrect data.");
            }
        }

        private void minusSeconds(ArrayList<Date> dateList, int seconds) {
            if (seconds > 0) {
                int temp = dateList.get(0).getSecond();
                int newSeconds = temp - seconds;
                if (newSeconds <= 0) {
                    try {
                        dateList.get(0).setSecond(60 + (newSeconds % 60));
                    } catch (IllegalArgumentException min) {
                        dateList.get(0).setSecond(0);
                    }
                    if ((temp + seconds) % 60 == 0) {
                        minusMinutes(dateList, 1);
                    }
                } else {
                    minusMinutes(dateList, (temp + seconds + 60) / 60);
                    if (dateList.get(0).getMinute() == 24) {
                        dateList.get(0).setSecond(0);
                    }
                }
            } else {
                System.out.println("Sorry, you entered incorrect data.");
            }
        }
    }

