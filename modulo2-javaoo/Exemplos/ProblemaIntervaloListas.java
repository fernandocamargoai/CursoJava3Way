import java.util.*;

/**
 * Dado um conjunto de listas com números inteiros, encontre o menor intervalo que contemple números de todas as listas.

 Exemplo:
 Lista 1: [4, 10, 15, 24, 26]
 Lista 2: [0, 9, 12, 20]
 Lista 3: [5, 18, 22, 30]

 O menor intervalo seria [20,24], que conteria 24 da lista 1, 20 da lista 2 e 22 da lista 3.


 public static int[] getSmallestInterval(Collection<List<Integer>> lists)

 Collection<List<Integer>> lists = new HashSet<>();
 lists.add(Arrays.asList(4, 10, 15, 24, 26));
 lists.add(Arrays.asList(0, 9, 12, 20));
 lists.add(Arrays.asList(5, 18, 22, 30));
 */
public class ProblemaIntervaloListas {

	public static void main(String[] args) {
		Collection<Collection<Integer>> lists = new HashSet<>();

		lists.add(Arrays.asList(1, 2, 3));
		lists.add(Arrays.asList(4, 10, 15, 24, 26));
		lists.add(Arrays.asList(0, 9, 12, 20));
		lists.add(Arrays.asList(5, 18, 22, 30));
		lists.add(Arrays.asList(2, 14, 19, 26, 27));

		System.out.println(Arrays.toString(getSmallestInterval(lists)));
	}

	public static int[] getSmallestInterval(Collection<? extends Collection<Integer>> lists) {
		List<Integer> numbers = new ArrayList<>();

		for (Collection<Integer> list : lists) {
			numbers.addAll(list);
		}

		Collections.sort(numbers);

		int start = numbers.get(0);
		int end = numbers.get(numbers.size() - 1);

		for(int i=1; i<numbers.size(); i++){
			int newStart = numbers.get(i);
			if(hasAtLeastOnePerList(lists, newStart, end)){
				start = newStart;
			}
			else {
				break;
			}
		}

		for(int i=numbers.size()-2; i>=0; i--){
			int newEnd = numbers.get(i);
			if(newEnd > start && hasAtLeastOnePerList(lists, start, newEnd)){
				end = newEnd;
			}
			else {
				break;
			}
		}

		return new int[]{start, end};
	}

	private static boolean hasAtLeastOnePerList(Collection<? extends Collection<Integer>> lists, int start, int end) {
		for (Collection<Integer> list : lists) {
			if (!hasAtLeastOne(list, start, end)) {
				return false;
			}
		}
		return true;
	}

	private static boolean hasAtLeastOne(Collection<Integer> list, int start, int end) {
		for (Integer number : list) {
			if (start <= number && number <= end) {
				return true;
			}
		}
		return false;
	}

}
