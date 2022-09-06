package lambda;

@FunctionalInterface
public interface ArithematicInterface<T,R>  {

	public R calc(T t, R r);
}
