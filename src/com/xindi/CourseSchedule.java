package com.xindi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CourseSchedule {
  //BFS
  public boolean canFinish1(int numCourses, int[][] prerequisites) {
    int[] indegrees = new int[numCourses];
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0;i<numCourses;i++){
      adj.add(new ArrayList<>());
    }
    for(int[] edge:prerequisites){
      indegrees[edge[0]]++;
      adj.get(edge[1]).add(edge[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for(int i=0;i<numCourses;i++){
      if(indegrees[i]==0) queue.offer(i);
    }
    while(!queue.isEmpty()){
      int course = queue.poll();
      numCourses--;
      for(int a : adj.get(course)){
        indegrees[a]--;
        if(indegrees[a]==0) queue.offer(a);
      }
    }
    return numCourses==0;
  }
  private List<List<Integer>> getAdj(int numCourses, int[][] prerequisites){
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0;i<numCourses;i++){
      adj.add(new ArrayList<>());
    }
    for(int[] edge:prerequisites){
      adj.get(edge[1]).add(edge[0]);
    }
    return adj;
  }

  //DFS
  public boolean canFinish2(int numCourses, int[][] prerequisites){
    List<List<Integer>> adj = getAdj(numCourses, prerequisites);
    int[] flag = new int[numCourses];
    for (int i=0;i<numCourses;i++) {
      if (!dfs(flag, i, adj)) return false;
    }
    return true;
  }

  private boolean dfs(int[] flag, int i, List<List<Integer>> adj){
    if(flag[i] == 1) return false;
    if(flag[i] == -1) return true;
    flag[i] = 1;
    for(int c : adj.get(i)){
      if(!dfs(flag, c, adj)) return false;
    }
    flag[i] = -1;
    return true;
  }

  public static void main(String[] args){
    int[][] p = new int[4][2];
    //[[0,1],[3,1],[1,3],[3,2]]
    p[0] = new int[]{0,1};
    p[1] = new int[]{3,1};
    p[2] = new int[]{1,3};
    p[3] = new int[]{3,2};
    CourseSchedule cs = new CourseSchedule();
    cs.canFinish2(4, p);
  }
}
