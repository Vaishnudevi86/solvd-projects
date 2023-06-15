package buildingcompany.interfaces;

@FunctionalInterface
public interface CalculatePrice<T> {
    float calculate(T t);
}