import { GraphNode } from './GraphNode';
import { GraphArc } from './GraphArc';

const DEFAULT_COST = 1;

export class Graph {
  private readonly nodes: Map<number, GraphNode> = new Map();

  constructor(names: string[], arcs: number[][]) {
    for (let i = 1; i <= names.length; i++) {
      this.nodes.set(i, new GraphNode(i, names[i - 1]));
    }

    for (const arc of arcs) {
      const from = this.nodes.get(arc[0]);
      const to = this.nodes.get(arc[1]);
      if (!from || !to) {
        throw new Error(`Invalid arc [${arc}] - node not found`);
      }
      const weight = arc.length > 2 ? arc[2] : DEFAULT_COST;
      const graphArc = new GraphArc(from, to, weight);
      from.addArc(graphArc);
    }
  }

  getNodeById(id: number): GraphNode | undefined {
    return this.nodes.get(id);
  }

  getAllNodes(): GraphNode[] {
    return Array.from(this.nodes.values());
  }
}
