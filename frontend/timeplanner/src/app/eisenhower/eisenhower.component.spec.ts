import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EisenhowerComponent } from './eisenhower.component';

describe('EisenhowerComponent', () => {
  let component: EisenhowerComponent;
  let fixture: ComponentFixture<EisenhowerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EisenhowerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EisenhowerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
