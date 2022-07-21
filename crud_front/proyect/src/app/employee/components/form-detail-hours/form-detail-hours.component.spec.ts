import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormDetailHoursComponent } from './form-detail-hours.component';

describe('FormDetailHoursComponent', () => {
  let component: FormDetailHoursComponent;
  let fixture: ComponentFixture<FormDetailHoursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormDetailHoursComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormDetailHoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
