import {useState} from 'react'
import SimpleHr from './simple-hr/SimpleHr'
import './App.css'

type ProjectKey = 'simpleHr' | null

const App = () => {
    const [selectedProject, setSelectedProject] = useState<ProjectKey>('simpleHr')

    return (
        <div className="app-root">
            <div className="app-layout">

                <aside className="app-sidebar">
                    <h2 className="sidebar-title">Projects</h2>

                    <button className={'sidebar-item' + (selectedProject === 'simpleHr' ? ' sidebar-item--active' : '')}
                            onClick={() => setSelectedProject('simpleHr')}>
                        Simple HR
                    </button>

                </aside>

                <main className="app-content">
                    {selectedProject === 'simpleHr' && <SimpleHr/>}

                    {!selectedProject && (
                        <div className="app-placeholder">
                            <p>Select a project from the left.</p>
                        </div>
                    )}
                </main>

            </div>
        </div>
    )
}

export default App
