import { Graph } from './Graph';
import { GraphNode } from './GraphNode';

export class NetflixProblem1DeepFirstTraversalSolution {
  private constructor() {}

  static newInstance(): NetflixProblem1DeepFirstTraversalSolution {
    return new NetflixProblem1DeepFirstTraversalSolution();
  }

  minNumberOfSemesters(n: number, prerequisites: number[][]): number {
    if (n === 0) {
      return 0;
    }

    if (prerequisites.length === 0) {
      return 1;
    }

    const graph = this.buildGraph(n, prerequisites);
    const longestPath = this.lengthOfLongestPath(graph);

    return longestPath + 1;
  }

  private buildGraph(n: number, prerequisites: number[][]): Graph {
    const names: string[] = [];
    for (let i = 0; i < n; i++) {
      names.push(`Course${i + 1}`);
    }
    return new Graph(names, prerequisites);
  }

  private lengthOfLongestPath(graph: Graph): number {
    const maxDepthsFromNodes = new Map<GraphNode, number>();
    const visiting = new Set<GraphNode>();

    let maxPath = 0;
    for (const node of graph.getAllNodes()) {
      const pathLength = this.deepFirstTraversal(
        node,
        maxDepthsFromNodes,
        visiting
      );
      maxPath = Math.max(maxPath, pathLength);
    }
    return maxPath;
  }

  private deepFirstTraversal(
    node: GraphNode,
    maxDepthsFromNodes: Map<GraphNode, number>,
    visiting: Set<GraphNode>
  ): number {
    if (maxDepthsFromNodes.has(node)) {
      return maxDepthsFromNodes.get(node)!;
    }
    if (visiting.has(node)) {
      return 0;
    }

    visiting.add(node);
    let maxDepth = 0;

    for (const arc of node.neighbors) {
      const neighbor = arc.to;
      const depth =
        1 +
        this.deepFirstTraversal(neighbor, maxDepthsFromNodes, visiting);
      maxDepth = Math.max(maxDepth, depth);
    }

    visiting.delete(node);
    maxDepthsFromNodes.set(node, maxDepth);

    return maxDepth;
  }

  private testSimpleExample(): boolean {
    const n = 4;
    const prerequisites = [
      [1, 2],
      [2, 3],
      [3, 4],
      [1, 4]
    ];
    return this.minNumberOfSemesters(n, prerequisites) === 4;
  }

  private testDisconnectedNodes(): boolean {
    const n = 4;
    const prerequisites: number[][] = [];
    return this.minNumberOfSemesters(n, prerequisites) === 1;
  }

  private testEmptyGraph(): boolean {
    const n = 0;
    const prerequisites: number[][] = [];
    return this.minNumberOfSemesters(n, prerequisites) === 0;
  }

  private testDisconnectedGraphs(): boolean {
    const n = 7;
    const prerequisites = [
      [1, 2],
      [2, 3],
      [3, 4],
      [1, 4],
      [5, 6],
      [6, 7]
    ];
    return this.minNumberOfSemesters(n, prerequisites) === 4;
  }

  static main(): void {
    const instance = NetflixProblem1DeepFirstTraversalSolution.newInstance();

    console.log("Test1 (simple): " + instance.testSimpleExample());
    console.log(
      "Test2 (disconnected nodes): " + instance.testDisconnectedNodes()
    );
    console.log("Test3 (empty graph): " + instance.testEmptyGraph());
    console.log(
      "Test4 (disconnected graphs): " + instance.testDisconnectedGraphs()
    );
  }
}

if (require.main === module) {
  NetflixProblem1DeepFirstTraversalSolution.main();
}
