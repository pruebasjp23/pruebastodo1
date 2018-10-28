import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionbodegaComponent } from './gestionbodega.component';

describe('GestionbodegaComponent', () => {
  let component: GestionbodegaComponent;
  let fixture: ComponentFixture<GestionbodegaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionbodegaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionbodegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
