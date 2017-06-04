package viti.kaf22.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Consumer;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
public class HelpUtil {

	public static <T, V> void executeBySetObject(T t, Class<V> type, Consumer<Object> c, boolean notFirst) {

		Arrays.asList(t.getClass().getMethods()).stream()
				.filter(m -> m.getReturnType().equals(type) && !m.getName().equals("subList")).forEach(m -> {
					try {
						Iterable<?> l = (Iterable<?>) m.invoke(t);
						if (l != null)
							l.forEach(no -> executeBySetObject(no, type, c, false));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		if (!notFirst) {
			c.accept(t);
		}
	}

	public static <T, V> void executeBySetObject(T t, Class<V> type, Consumer<Object> c, boolean notFirst,
			Class<?>... types) {
		if (Arrays.asList(types).contains(t.getClass()))
			return;
		Arrays.asList(t.getClass().getMethods()).stream()
				.filter(m -> m.getReturnType().equals(type) && !m.getName().equals("subList")).forEach(m -> {
					try {
						Iterable<?> l = (Iterable<?>) m.invoke(t);
						if (l != null)
							l.forEach(no -> executeBySetObject(no, type, c, false, types));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		if (!notFirst) {
			c.accept(t);
		}
	}

	public static <T, V> void initSetObjects(T t, Class<V> type) {

		Arrays.asList(t.getClass().getMethods()).stream()
				.filter(m -> m.getReturnType().equals(type) && !m.getName().equals("subList")).forEach(m -> {
					try {
						if (m != null) {
							Iterable<?> l = (Iterable<?>) m.invoke(t);
							if (l != null)
								l.forEach(no -> initSetObjects(no, type));
						}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		Arrays.asList(t.getClass().getMethods()).stream()
				.filter(m -> m.getReturnType().equals(type) && !m.getName().equals("subList")).forEach(m -> {
					try {
						Iterable<?> l = (Iterable<?>) m.invoke(t);
						if (l != null)
							l.forEach(no -> Arrays.asList(no.getClass().getMethods()).stream()
									.filter(non -> non.getParameterTypes().length > 0
											&& non.getParameterTypes()[0].equals(t.getClass()))
									.forEach(non -> {
										try {
											non.invoke(no, t);
										} catch (IllegalAccessException | IllegalArgumentException
												| InvocationTargetException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
	}

	private static ArrayList<Object> list = new ArrayList<>();

	public static void clearBuffer() {
		list.clear();
	}

	public static <T, V> void initUserObjects(T t, Class<V> type) {

		list.add(t);
		Arrays.asList(t.getClass().getMethods()).stream()
				.filter(m -> type.isAssignableFrom(m.getReturnType()) && !m.getReturnType().equals(String.class)
						&& !m.getReturnType().isEnum() && !m.getReturnType().equals(Date.class)
						&& !m.getReturnType().isPrimitive() && !m.getReturnType().isSynthetic()
						&& !(m.getParameterTypes().length > 0) && !Modifier.isStatic(m.getModifiers())
						&& !Modifier.isNative(m.getModifiers()))
				.forEach(m -> {
					try {
						Object invoke = m.invoke(t);
						if (invoke != null)
							Arrays.asList(invoke.getClass().getMethods()).stream()
									.filter(non -> non.getParameterTypes().length > 0
											&& non.getParameterTypes()[0].equals(t.getClass()))
									.forEach(non -> {
										try {
											non.invoke(invoke, t);
										} catch (IllegalAccessException | IllegalArgumentException
												| InvocationTargetException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									});
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		Arrays.asList(t.getClass().getMethods()).stream()
				.filter(m -> type.isAssignableFrom(m.getReturnType()) && !m.getReturnType().equals(String.class)
						&& !m.getReturnType().isEnum() && !m.getReturnType().equals(Date.class)
						&& !m.getReturnType().isPrimitive() && !m.getReturnType().isSynthetic()
						&& !(m.getParameterTypes().length > 0) && !Modifier.isStatic(m.getModifiers())
						&& !Modifier.isNative(m.getModifiers()))
				.forEach(m -> {
					try {
						if (m.invoke(t) != null && !list.contains(m.invoke(t)))
							initUserObjects(m.invoke(t), type);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				});

	}

	public static <T, V> void executeByUserObjects(T t, Class<V> type, Consumer<Object> c, boolean notFirst) {
		list.add(t);
		Arrays.asList(t.getClass().getMethods()).stream()
				.filter(m -> type.isAssignableFrom(m.getReturnType()) && !m.getReturnType().equals(String.class)
						&& !m.getReturnType().equals(Set.class) && !m.getReturnType().equals(Date.class)
						&& !m.getReturnType().isPrimitive() && !m.getReturnType().isEnum()
						&& !(m.getParameterTypes().length > 0) && !Modifier.isStatic(m.getModifiers())
						&& !Modifier.isNative(m.getModifiers()))
				.forEach(m -> {
					try {
						if (m.invoke(t) != null && !list.contains(m.invoke(t)))
							executeByUserObjects(m.invoke(t), type, c, false);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				});
		if (!notFirst) {
			c.accept(t);
		}
	}

	public static <T, V> void executeByUserObjects(T t, Class<V> type, Consumer<Object> c, boolean notFirst,
			Class<?>... types) {
		if (Arrays.asList(types).contains(t.getClass()))
			return;
		list.add(t);
		Arrays.asList(t.getClass().getMethods()).stream()
				.filter(m -> type.isAssignableFrom(m.getReturnType()) && !m.getReturnType().equals(String.class)
						&& !m.getReturnType().isEnum() && !m.getReturnType().equals(Date.class)
						&& !m.getReturnType().isPrimitive() && !m.getReturnType().isSynthetic()
						&& !(m.getParameterTypes().length > 0) && !Modifier.isStatic(m.getModifiers())
						&& !Modifier.isNative(m.getModifiers()))
				.forEach(m -> {
					try {
						if (m.invoke(t) != null && !list.contains(m.invoke(t)))
							executeByUserObjects(m.invoke(t), type, c, false, types);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				});
		if (!notFirst) {
			c.accept(t);
		}
	}

	private static HashMap<String, String> map;

	public static HashMap<String, String> getTrace(Exception e) {
		// FIRST
		// REAL NEED
		// message:Duplicate entry 'ЦМД-1221' for key 'Osobova_sprava_id'
		// class java.sql.SQLIntegrityConstraintViolationException

		map = new HashMap<>();
		recurciveGet(map, e);

		return map;
	}

	private static void recurciveGet(HashMap<String, String> map, Throwable e) {
		// TODO Auto-generated method stub
		map.put(e.getClass().toString(), e.getMessage());
		if (e.getCause() != null)
			recurciveGet(map, e.getCause());
	}
}
