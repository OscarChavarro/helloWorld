import type { GraphNode } from './GraphNode';

export class GraphArc {
  private readonly _from: GraphNode;
  private readonly _to: GraphNode;
  private readonly _cost: number;

  constructor(from: GraphNode, to: GraphNode, cost: number) {
    this._from = from;
    this._to = to;
    this._cost = cost;
  }

  get from(): GraphNode {
    return this._from;
  }

  get to(): GraphNode {
    return this._to;
  }

  get cost(): number {
    return this._cost;
  }
}
