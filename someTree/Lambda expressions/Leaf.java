import java.util.function.Function;

public class Leaf<V, T> implements Node<V, T> {
    private V leafInfo;
    public Leaf(V leaf) { leafInfo = leaf; }
    public <R> R process(Function<V,R> leafProcessor,
                         TreeFunction<T,R> biNodeProcessor) {
        return leafProcessor.apply(leafInfo);
    }
}
