import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate, TextFormat, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity as getEntityCarrera } from '../../entities/carrera/carrera.reducer';
import { getEntity as getEntitySolicitudReingreso } from '../../entities/solicitud-reingreso/solicitud-reingreso.reducer';
import { getEntity as getEntityPensum } from '../../entities/pensum/pensum.reducer';
import { getEntity as getEntitySede } from '../../entities/sede/sede.reducer';
import { getEntity as getEntityEstudianteIngresoEstudiante } from '../../entities/ingreso-estudiante/ingreso-estudiante.reducer';
import { getEntity as getEntityEstudiante } from '../../entities/estudiante/estudiante.reducer';

export const AdminPapel = () => {
  return (
    <body className="page custom-body">
      <div className="row-container">
        <h2>Obtener el programa del estudiante en base a su ID</h2>
        <div className="button-container">
          <label className="button-container-label">Ingrese el ID</label>
          <ValidatedField name="id" id="info1" type="text" />
          <button className="button button-primary">Buscar</button>
        </div>
      </div>

      <div className="row-container">
        <h2>Obtenga la información del estado de un estudiante por su ID</h2>
        <div className="button-container">
          <label className="button-container-label">Ingrese el ID</label>
          <ValidatedField name="id" id="info2" type="text" />
          <button className="button button-primary">Buscar</button>
        </div>
      </div>

      <div className="row-container">
        <h2>Obtener el correo institucional del estudiante en base a su ID</h2>
        <div className="button-container">
          <label className="button-container-label">Ingrese el ID</label>
          <ValidatedField name="id" id="info3" type="text" />
          <button className="button button-primary">Buscar</button>
        </div>
      </div>

      <div className="row-container">
        <h2>Buscar los estudiantes matriculados en una carrera, con el ID de la carrera</h2>
        <div className="button-container">
          <label className="button-container-label">Ingrese el ID</label>
          <ValidatedField name="id" id="info4" type="text" />
          <button className="button button-primary">Buscar</button>
        </div>
      </div>

      <div className="row-container">
        <h2>Obtener la facultad a la que pertenece una carrera, en base a su ID carrera</h2>
        <div className="button-container">
          <label className="button-container-label">Ingrese el ID</label>
          <ValidatedField name="id" id="info5" type="text" />
          <button className="button button-primary">Buscar</button>
        </div>
      </div>

      <div className="row-container">
        <h2>Mostrar los estudiantes que están activos/inactivos por su estado</h2>
        <div className="button-container">
          <label className="button-container-label">Ingrese el estado (Activo - inactivo)</label>
          <ValidatedField name="id" id="info6" type="text" />
          <button className="button button-primary">Buscar</button>
        </div>
      </div>

      <div className="row-container">
        <h2>Buscar estudiantes que pertenecen a una carrera, por su estado y ID carrera</h2>
        <div className="button-container">
          <label className="button-container-label">Ingrese el ID carrera</label>
          <ValidatedField name="id" id="info7a" type="text" />
        </div>

        <div className="button-container">
          <label className="button-container-label">Ingrese el estado (Activo - inactivo)</label>
          <ValidatedField name="id" id="info7b" type="text" />
          <button className="button button-primary">Buscar</button>
        </div>
      </div>

      <div className="row-container">
        <h2>Buscar estudiantes por género y ID carrera</h2>
        <div className="button-container">
          <label className="button-container-label">Ingrese el ID carrera</label>
          <ValidatedField name="id" id="info8a" type="text" />
        </div>

        <div className="button-container">
          <label className="button-container-label">Ingrese el género (hombre - mujer)</label>
          <ValidatedField name="id" id="info8b" type="text" />
          <button className="button button-primary button-specific">Buscar</button>
        </div>
      </div>
    </body>
  );
};

export default AdminPapel;
