import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import AdminPapel from './admin-panel';

const AdminPapelRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<AdminPapel />} />
  </ErrorBoundaryRoutes>
);

export default AdminPapelRoutes;
