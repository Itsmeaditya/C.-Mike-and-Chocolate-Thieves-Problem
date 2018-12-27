
import java.util.*;

public class TheivesMaxBagSize {

	public static List<Map<Integer,Integer>> combinations = new ArrayList<Map<Integer,Integer>>();
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter m");
		Integer m = new Integer(sc.nextInt());
		for( Integer i=1;i<m;i++)
		{
			for( Integer j=2;j<m+2;j++)
			{

				Integer bagSize = new Integer((int)(i*Math.pow(j, 3)));
				if(combinations.size() < m)
				{
					Map<Integer,Integer> temp = new HashMap<>();
					temp.put(i, bagSize);
					combinations.add(temp);

				}
				else
				{
					List<Integer> list = new ArrayList<Integer>();

					for( Integer index=0;index< combinations.size();index++)
					{
						Map<Integer,Integer> map = combinations.get(index);
						for( Integer key: map.keySet())
							list.add(map.get(key));
					}

					Collections.sort(list);
					
					int compare = bagSize.compareTo(list.get(m-1));

					if( (compare < 0) && !list.contains(bagSize))
					{
						for( int index=0;index<combinations.size();index++)
						{
							boolean flag = false;
							Map<Integer,Integer> map = combinations.get(index);
							for( Integer key: map.keySet())
							{
								if( map.get(key).equals(list.get(m-1)))
								{
									flag = true;
									combinations.remove(index);
									break;
								}

							}
							if( flag)
								break;
						}
						Map<Integer,Integer> temp = new HashMap<>();
						temp.put(i, bagSize);
						combinations.add(temp);

					}
					else if( list.contains(bagSize))
					{
						System.out.println("Violating with bag size of "+bagSize);
						System.out.println("-1");
						System.exit(0);
					}
					else
						break;

				}

			}
		}

		for(int c=0;c<combinations.size();c++)
		{
			Map<Integer,Integer> temp = combinations.get(c);
			for( Integer key: temp.keySet())
				System.out.println(key+ " --> "+ temp.get(key));
		}
	}

}
