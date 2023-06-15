package com.solvd.practice;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Logger logger = LogManager.getLogger(buildingcompany.Main.class);
    public static void main(String[] args) {
        int[] array = {20, 80, -2, 50, 10, 5};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.performBubbleSort(array);
       logger.info(Arrays.toString(array));
       logger.info("RUN SUCCESS");

        /*Employee employee = new Employee("FN1", "LN1", "111-222-3333",
                "Address1", "MGR", "Manager");

       logger.info(employee.getRoleShortDesc());*/

    }

}
