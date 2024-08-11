import { v4 as uuid } from "uuid";

export class Subtask {
  id: string = uuid();
  taskId: string = uuid();
  title: string = "";
  description: string = "";
  isEditing?: boolean;
}
