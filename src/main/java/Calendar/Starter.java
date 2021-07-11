package Calendar;

import Calendar.WorkForDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {


        public void start() {
            WorkForDate workForDate = new WorkForDate();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("""
                    Select function:
                    1 - adding to date
                    2 - Subtracting from a date
                    3 - Date difference
                    4 - Date comparison
                    0 - Exit""");

            try {

                String read;

                while ((read = reader.readLine()) != null) {
                    switch (read) {
                        case "1" -> workForDate.add();
                        case "2" -> workForDate.minus();
                        case "3" -> workForDate.difference();
                        case "4" -> workForDate.compare();
                        case "0" -> System.exit(0);
                        default -> System.out.println("Sorry, you entered the wrong value. " + read);
                    }
                }
            }
            catch (IOException | IllegalStateException | IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

