package interfaces;

@FunctionalInterface
public interface IHasNavigation<T extends IHrefSupplier> {

    void navigateTo(T link);
}
