import { v4 as uuid } from "uuid";

export class Task {
  id: string = uuid();
  title: string = "";
  description: string = "";
  estimation: string = "";
  priority: string = "";
  deadline: Date = new Date();
  isEditing?: boolean;
}
