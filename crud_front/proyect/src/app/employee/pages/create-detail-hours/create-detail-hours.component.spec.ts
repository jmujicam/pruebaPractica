import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDetailHoursComponent } from './create-detail-hours.component';

describe('CreateDetailHoursComponent', () => {
  let component: CreateDetailHoursComponent;
  let fixture: ComponentFixture<CreateDetailHoursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateDetailHoursComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateDetailHoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
