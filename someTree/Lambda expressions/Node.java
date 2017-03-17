import java.util.function.Function;

public interface Node<V, T> {
    <R> R process(Function<V,R> leafProcessor,
                  TreeFunction<T,R> biNodeProcessor);
}
