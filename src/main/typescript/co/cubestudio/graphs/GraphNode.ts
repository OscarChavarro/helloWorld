import { GraphArc } from './GraphArc';

export class GraphNode {
  private readonly _id: number;
  private readonly _name: string;
  private _neighbors: GraphArc[] = [];

  constructor(id: number, name: string) {
    this._id = id;
    this._name = name;
  }

  get id(): number {
    return this._id;
  }

  get name(): string {
    return this._name;
  }

  get neighbors(): GraphArc[] {
    return this._neighbors;
  }

  set neighbors(neighbors: GraphArc[]) {
    this._neighbors = neighbors;
  }

  addArc(arc: GraphArc): void {
    this._neighbors.push(arc);
  }
}
