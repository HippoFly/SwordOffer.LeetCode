package com.so.leetcode;

import java.util.*;

/**
 * LeetCode 207. 课程表
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则必须先学习课程 bi 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * <p>
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0；
 * 并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * @author FlyHippo
 * @version 1.0
 **/

public class Q207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 建立图（邻接表）和入度数组
        /** 解释
         * 课表有向图
         * 0 -> 1
         * 0 -> 2
         * 1 -> 3
         * 转化为 list
         * [
         *   [1, 2],   // 课程 0 指向 1、2
         *   [3],      // 课程 1 指向 3
         *   [],       // 课程 2 没有后续
         *   []        // 课程 3 没有后续
         * ]
         * 方便表示 有向图。
         *
         * 遍历某个课程的后续课程时，只要 for (int next : adjacencyList.get(course)) 就能得到所有后继。
         *
         * 节省空间：如果用邻接矩阵（二维数组）要占 O(V^2) 空间，而邻接表只需要 O(V+E)。
         */
        List<List<Integer>> adjacencyList = new ArrayList<>(); // 邻接表（有向图）
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses]; // 存储每个课程的入度

        // prerequisites[i] = [course, preCourse] 存储有向图
        // 表示 preCourse -> course
        for (int[] relation : prerequisites) {
            int course = relation[0]; // 入度课程 ，也是记录入度的索引
            int preCourse = relation[1]; //前置课程
            adjacencyList.get(preCourse).add(course);
            inDegree[course]++;
        }

        // 2. 把所有入度为 0 的课程放进队列（可以立刻学习的课）
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {  // 入度为 0 的课程可以学习
                queue.offer(i);
            }
        }

        // 3. BFS 遍历，模拟学习课程的过程
        int finishedCourses = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            finishedCourses++;

            // 遍历当前课程的所有后继课程
            for (int nextCourse : adjacencyList.get(currentCourse)) {
                inDegree[nextCourse]--; // 学完当前课，后继课的入度减一
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse); // 没有前置依赖了，可以学习
                }
            }
        }

        // 4. 如果学完的课程数等于总课程数，说明能学完；否则有环
        return finishedCourses == numCourses;
    }

    public static void main(String[] args) {
        Q207_CourseSchedule solution = new Q207_CourseSchedule();

        // 测试示例1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("示例1结果: " + solution.canFinish(numCourses1, prerequisites1));
        // 应该输出true

        // 测试示例2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("示例2结果: " + solution.canFinish(numCourses2, prerequisites2));
        // 应该输出false

        // 使用DFS方法测试示例1
//        System.out.println("示例1 DFS结果: " + solution.canFinishDFS(numCourses1, prerequisites1));
        // 应该输出true

        // 使用DFS方法测试示例2
//        System.out.println("示例2 DFS结果: " + solution.canFinishDFS(numCourses2, prerequisites2));
        // 应该输出false
    }
}