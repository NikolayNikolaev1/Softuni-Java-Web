package telephony.models;

import telephony.interfaces.Browsable;
import telephony.interfaces.Callable;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.setNumbers(numbers);
        this.setUrls(urls);
    }

    private void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    private void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();

        for (String number : this.numbers) {
            if (number.matches("\\d+")) {
                result.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                result.append("Invalid number!").append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();

        for (String url : this.urls) {
            if (url.matches("\\D+")) {
                result.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                result.append("Invalid URL!").append(System.lineSeparator());
            }
        }

        return result.toString();
    }
}
