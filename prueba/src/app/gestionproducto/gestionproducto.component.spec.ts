import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionproductoComponent } from './gestionproducto.component';

describe('GestionproductoComponent', () => {
  let component: GestionproductoComponent;
  let fixture: ComponentFixture<GestionproductoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionproductoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionproductoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
