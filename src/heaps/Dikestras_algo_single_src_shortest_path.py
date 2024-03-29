class Solution:
    def networkDelayTime(self, times, n: int, src: int) -> int:
      """
      Time Complexity - > For E edges and V vertices -> O(E + VLogV) for Fibonacci Heap
      Space Complexity -> O(V)
      Short come of this Algorithm is that it cannot process graph with negative edges. 
      This is used over BFS because, BFS only works on unweighted graphs. 
      """
        import heapq
        # The tuple is of form <distance, Node, parent>
        pq = [(0, src, -1)]
        graph = defaultdict(list)

        # Graph Built
        for u, v, w in times:
            graph[u].append([v, w])
        
        dist = {}
        parent = {}
        heapq.heapify(pq)

        while pq:
            dst, node, prnt = heapq.heappop(pq)
            if node in dist:
                continue
            dist[node] = dst
            parent[node] = prnt
            for nbr, wt in graph[node]:
                if nbr not in dist:
                    heapq.heappush([wt+dst, nbr, node])
        
        return max(dist.values()) if len(dist) == n else -1
