import {Component, OnInit} from '@angular/core';
import {
  CdkDrag,
  CdkDragDrop,
  CdkDropList,
  CdkDropListGroup,
  moveItemInArray,
  transferArrayItem,
} from '@angular/cdk/drag-drop';
import {TaskService} from "../service/task.service";
import { Task } from '../model/task';
import {NgIf} from "@angular/common";

/**
 * @title Drag&Drop disabled sorting
 */
@Component({
  selector: 'eisenhower-component',
  templateUrl: './eisenhower.component.html',
  standalone: true,
  imports: [CdkDropListGroup, CdkDropList, CdkDrag, NgIf],
  styleUrl: './eisenhower.component.scss'
})
export class EisenhowerComponent implements OnInit{

  constructor(private taskService: TaskService) {
  }
  priorities: string[] = [];
  sortedTasks: { [key: string]: Task[] } = {};


  ngOnInit(): void {
    this.getTasks();
  }

  private getTasks() {
    this.taskService.getPriorities().subscribe(data =>
      this.priorities = data);
    this.taskService.getTasks().subscribe(data =>
      this.priorities.forEach(priority => {
        let initialTask = new Task()
        initialTask.priority = priority;
        this.sortedTasks[priority] = data.filter(task => task.priority === priority)
        this.sortedTasks[priority].push(initialTask);
      })
    );
  }

  drop(event: CdkDragDrop<Task[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      console.log(event.container.data)

      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex,
      );
      let InitialTaskPriority = event.container.data.find(e=> e.title === "")
      if(InitialTaskPriority != undefined) {
        event.container.data[event.currentIndex].priority = InitialTaskPriority.priority
        this.taskService.updateTask(event.container.data[event.currentIndex]).subscribe({complete: console.info});
      }

    }
  }
}
