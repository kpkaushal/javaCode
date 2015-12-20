package javaCode;

public class treeHeight
{
	static int getTreeHeight (int iCycleInput)
	{
		int iTreeHeight = 0;
		for (int iCycle = 0; iCycle <= iCycleInput; iCycle++)
		{
			if (iCycle % 2 == 0)
				iTreeHeight += 1;
			else
				iTreeHeight = iTreeHeight*2;
		}
		return iTreeHeight;
	}

	static int[] getHeight(int[] input)
	{
		int[] treeHeights = new int[input.length];
		for (int i = 0; i < input.length; i++)
			treeHeights[i] = getTreeHeight(input[i]);
		return treeHeights;
	}
	
	public static void main (String[] args)
	{
		//The utopian tree goes through 2 cycles of growth every year. The first growth cycle occurs during the monsoon, when it doubles in height.
		//The second growth cycle occurs during the summer and increases by 1 meter.
		//A new tree is planted at the onset of the monsoon, it height is 1 meter. What is its height after n cycles?

		int[] cycleCount = {0,1,3,4};
		int[] treeHeight = getHeight(cycleCount);
		for (int i = 0; i < treeHeight.length; i++)
			System.out.println(treeHeight[i]);
	}
}